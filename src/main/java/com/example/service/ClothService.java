package com.example.service;

import com.example.domain.Cloth;
import com.example.repository.ClothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Clothに関する業務処理を行うサービスクラスです.
 *
 * @author takuto.itami
 */
@Service
@Transactional
public class ClothService {

    @Autowired
    private ClothRepository clothRepository;

    /**
     * 指定された色と性別で衣類を検索したリストを取得するメソッドです.
     *
     * @param color 検索に使用する色
     * @param gender 検索に使用する性別
     * @return 価格の昇順で取得した検索結果の衣類リスト
     */
    public List<Cloth> searchByColorAndGender(String color, Integer gender) {
        List<Cloth> clothList = clothRepository.findByColorAndGender(color, gender);
        return clothList;
    }

    /**
     * DBに衣類データが存在するかどうかをチェックします.
     *
     * @return 全件取得でデータが存在するかどうかの真偽値
     */
    public boolean isClothesExist() {
        List<Cloth> clothList = clothRepository.findAll();
        if (clothList.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * DBに存在する色のリンクドリストを取得します.
     *
     * @return DBに存在する色のリンクドリスト
     */
    public List<String> createColorList() {
        List<Cloth> clothList = clothRepository.findAll();
        List<String> colorList = new ArrayList<>();
        List<String> uniqueColorList = new LinkedList<>();

        for (Cloth cloth : clothList) {
            colorList.add(cloth.getColor());
        }

        for (String color: colorList) {
            if (!uniqueColorList.contains(color)) {
                uniqueColorList.add(color);
            }
        }

        return uniqueColorList;
    }
}
