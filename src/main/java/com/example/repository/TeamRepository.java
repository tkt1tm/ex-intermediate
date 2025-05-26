package com.example.repository;

import com.example.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * チームのリポジトリを表すクラスです.
 *
 * @author takuto.itami
 */
@Repository
public class TeamRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Team> TEAM_ROW_MAPPER = (rs, i) -> {
        Team team = new Team();
        team.setId(rs.getInt("id"));
        team.setLeagueName(rs.getString("league_name"));
        team.setTeamName(rs.getString("team_name"));
        team.setHeadquarters(rs.getString("headquarters"));
        team.setInauguration(rs.getString("inauguration"));
        team.setHistory(rs.getString("history"));
        return team;
    };

    /**
     * チーム情報を発足日の昇順で全件取得します.
     *
     * @return 発足日の昇順に並べられたチーム全件の情報
     */
    public List<Team> findAll() {
        String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams ORDER BY inauguration;";

        List<Team> teams = template.query(sql, TEAM_ROW_MAPPER);

        return teams;
    }

    /**
     * チーム情報を渡されたIDをもとに1件取得します.
     *
     * @param id 検索に使用するID
     * @return IDをもとに取得した1件のチーム情報
     */
    public Team findById(int id) {
        String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams WHERE :id = id;";

        SqlParameterSource param = new MapSqlParameterSource("id", id);

        Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);

        return team;
    }
}
