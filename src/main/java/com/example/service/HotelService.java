package com.example.service;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ホテルに関する機能の業務処理を行うクラスです.
 *
 * @author takuto.itami
 */
@Service
@Transactional
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    /**
     * 指定された価格以下のホテルを検索するメソッドです.
     *
     * @param price 検索の条件に使用するホテルの価格
     * @return 指定された価格よりも安いホテルの情報が入ったリスト(ない場合は全件のリスト)
     */
    public List<Hotel> searchByLessThanPrice(String price) {
        List<Hotel> hotelList;
        if (price.isEmpty()) {
            hotelList = hotelRepository.findAll();
        } else {
            hotelList = hotelRepository.findByPrice(Integer.parseInt(price));
        }
        return hotelList;
    }
}
