package com.example.controller;

import com.example.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("list", teamService.showList());
        return "show-list";
    }

    @GetMapping("/show-detail")
    public String showDetail(int id, Model model) {
        model.addAttribute("team", teamService.showDetail(id));
        return "show-detail";
    }
}
