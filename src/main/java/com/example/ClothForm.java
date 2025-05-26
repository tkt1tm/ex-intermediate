package com.example;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * 検索時の入力値を扱うFormクラスです.
 *
 * @author takuto.itami
 */
public class ClothForm {
    /** 性別 */
    @NotNull(message = "性別を選択してください")
    private Integer gender;
    /** 色 */
    @NotEmpty(message = "色を選択してください")
    private String color;

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ClothForm{" +
                "gender=" + gender +
                ", color='" + color + '\'' +
                '}';
    }
}
