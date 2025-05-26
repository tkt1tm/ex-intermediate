package com.example.repository;

import com.example.domain.Cloth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Clothesテーブルを操作するリポジトリクラスです.
 *
 * @author takuto.itami
 */
@Repository
public class ClothRepository {

    private static final RowMapper<Cloth> CLOTH_ROW_MAPPER = (rs, i) -> {
        Cloth cloth = new Cloth();
        cloth.setId(rs.getInt("id"));
        cloth.setCategory(rs.getString("category"));
        cloth.setGenre(rs.getString("genre"));
        cloth.setGender(rs.getInt("gender"));
        cloth.setColor(rs.getString("color"));
        cloth.setPrice(rs.getInt("price"));
        cloth.setSize(rs.getString("size"));
        return cloth;
    };

    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * 指定された色と性別で衣類を検索するメソッドです.
     *
     * @param color 検索に使用する色
     * @param gender 検索に使用する性別
     * @return 価格の昇順で取得した検索結果の衣類リスト
     */
    public List<Cloth> findByColorAndGender(String color, Integer gender) {
        String sql = "SELECT id, category, genre, gender, color, price, size FROM clothes WHERE color = :color AND gender = :gender ORDER BY price;";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("color", color)
                .addValue("gender", gender);

        List<Cloth> clothList = template.query(sql, param, CLOTH_ROW_MAPPER);

        return clothList;
    }

    /**
     * 衣類を全検索するメソッドです.
     *
     * @return 価格の昇順で取得した全件検索結果の衣類リスト
     */
    public List<Cloth> findAll() {
        String sql = "SELECT id, category, genre, gender, color, price, size FROM clothes ORDER BY price;";

        List<Cloth> clothList = template.query(sql, CLOTH_ROW_MAPPER);

        return clothList;
    }
}