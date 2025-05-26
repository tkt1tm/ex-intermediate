package com.example.repository;

import com.example.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * hotelsテーブルを操作するリポジトリです.
 *
 * @author takuto.itami
 */
@Repository
public class HotelRepository {
    private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
        Hotel hotel = new Hotel();
        hotel.setId(rs.getInt("id"));
        hotel.setAreaName(rs.getString("area_name"));
        hotel.setHotelName(rs.getString("hotel_name"));
        hotel.setAddress(rs.getString("address"));
        hotel.setNearestStation(rs.getString("nearest_station"));
        hotel.setPrice(rs.getInt("price"));
        hotel.setParking(rs.getString("parking"));
        return hotel;
    };

    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * ホテルを全件検索するメソッドです.
     *
     * @return 全ホテルの情報が入ったリスト
     */
    public List<Hotel> findAll() {
        String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels ORDER BY price;";

        List<Hotel> hotels = template.query(sql, HOTEL_ROW_MAPPER);

        return hotels;
    }


    /**
     * 指定された価格以下のホテルを検索するメソッドです.
     *
     * @param price 検索の条件に使用するホテルの価格
     * @return 指定された価格よりも安いホテルの情報が入ったリスト
     */
    public List<Hotel> findByPrice(int price) {
        String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels WHERE price <= :price ORDER BY price;";

        SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);

        List<Hotel> hotels = template.query(sql, param, HOTEL_ROW_MAPPER);

        return hotels;
    }

}
