package com.example.service;

import com.example.domain.Team;
import com.example.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<Team> showList() {
        List<Team> list = teamRepository.findAll();
        return list;
    }
}
