package com.example.controller;

import com.example.domain.Hotel;
import com.example.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.regex.Pattern;

/**
 * ホテルに関する機能の制御を行うコントローラです.
 *
 * @author takuto.itami
 */
@Controller
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    /**
     * 検索画面を表示させるメソッド.
     *
     * @param model 検索結果を格納するリクエストスコープ
     * @return 検索画面にフォワードします
     */
    @GetMapping("")
    public String showList(Model model) {
        return "hotel-list";
    }

    /**
     * 入力に従ってホテルを検索させるメソッド.
     *
     * @param price 入力された価格
     * @param model 検索結果を格納するリクエストスコープ
     * @return showListメソッドを呼びます
     */
    @PostMapping("/search")
    public String search(String price, Model model) {
        List<Hotel> hotelList;

        if (!Pattern.matches("^$|^\\d+$", price)) {
            model.addAttribute("stringGiven", true);
            return showList(model);
        }

        hotelList = hotelService.searchByLessThanPrice(price);

        if (hotelList.isEmpty()) {
            model.addAttribute("noMatch", true);
            model.addAttribute("price", price);
            return showList(model);
        }

        model.addAttribute("hotelList", hotelList);

        return showList(model);
    }
}
