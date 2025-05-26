package com.example.controller;

import com.example.ClothForm;
import com.example.domain.Cloth;
import com.example.service.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Clothに関する機能の制御を行うコントローラクラスです.
 *
 * @author takuto.itami
 */
@Controller
@RequestMapping("/clothes")
public class ClothController {
    @Autowired
    private ClothService clothService;

    /**
     * 検索画面と検索結果画面を表示します.
     *
     * @param model リクエストスコープを格納
     * @param clothForm 入力値チェック/エラーメッセージ用のFormクラスオブジェクト
     * @return 検索画面と検索結果画面にフォワード
     */
    @GetMapping("")
    public String showClothes(Model model, ClothForm clothForm) {
        model.addAttribute("colorList", clothService.createColorList());
        return "show-clothes";
    }


    /**
     * 入力値に従って衣類を検索します.
     *
     * @param clothForm 入力値チェック/エラーメッセージ用のFormクラスオブジェクト
     * @param result エラーメッセージを格納
     * @param model リクエストスコープを格納
     * @return 入力値や結果に従って異なる引数を渡してshowClothesを呼びます
     */
    @PostMapping("/search")
    public String search(@Validated ClothForm clothForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return showClothes(model, clothForm);
        }

        if (!clothService.isClothesExist()) {
            model.addAttribute("noData", true);
            return showClothes(model, clothForm);
        }

        List<Cloth> clothList = clothService.searchByColorAndGender(clothForm.getColor(), clothForm.getGender());

        if (clothList.isEmpty()) {
            model.addAttribute("noMatch", true);
            return showClothes(model, clothForm);
        }

        model.addAttribute("clothList", clothList);

        return showClothes(model, clothForm);
    }
}
