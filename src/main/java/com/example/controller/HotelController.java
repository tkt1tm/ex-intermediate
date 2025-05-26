package com.example.controller;

import com.example.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ホテルアプリのコントローラを表すクラスです.
 *
 * @author takuto.itami
 */
@Controller
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("hotelList", hotelService.findAll());

        return "hotel-list";
    }
}
