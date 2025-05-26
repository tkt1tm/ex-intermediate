package com.example.service;

import com.example.domain.Team;
import com.example.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * チームのサービスを表すクラスです.
 *
 * @author takuto.itami
 */
@Service
@Transactional
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    /**
     * チーム情報を発足日の昇順で全件取得します.
     *
     * @return 発足日の昇順に並べられたチーム全件の情報
     */
    public List<Team> showList() {
        List<Team> list = teamRepository.findAll();
        return list;
    }

    /**
     * チーム情報を渡されたIDをもとに1件取得します.
     *
     * @param id 検索に使用するID
     * @return IDをもとに取得した1件のチーム情報
     */
    public Team showDetail(int id) {
        Team team = teamRepository.findById(id);
        return team;
    }
}
