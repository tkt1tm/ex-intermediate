package com.example.controller;

import com.example.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * チームのコントローラを表すクラスです.
 *
 * @author takuto.itami
 */
@Controller
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;

    /**
     * 一覧画面に遷移させます.
     *
     * @param model 一覧表示するチーム情報を格納するリクエストスコープ
     * @return 一覧画面にフォワードさせます
     */
    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("TeamList", teamService.showList());
        return "show-list";
    }

    /**
     * チームの詳細画面を表示します.
     *
     * @param id 詳細を表示したいチームのID
     * @param model チーム情報を格納するリクエストスコープ
     * @return 詳細画面にフォワードさせます
     */
    @GetMapping("/show-detail")
    public String showDetail(int id, Model model) {
        model.addAttribute("team", teamService.showDetail(id));
        return "show-detail";
    }
}
