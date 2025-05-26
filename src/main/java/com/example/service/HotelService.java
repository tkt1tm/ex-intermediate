package com.example.service;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ホテルサービスを表すクラスです.
 *
 * @author takuto.itami
 */
@Service
@Transactional
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    /**
     * ホテルを全件取得してくるメソッドです.
     *
     * @return ホテルの情報が全件入ったリスト
     */
    public List<Hotel> findAll() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels;
    }

    /**
     * 指定された価格以下のホテルを検索するメソッドです.
     *
     * @param price 検索の条件に使用するホテルの価格
     * @return 指定された価格よりも安いホテルの情報が入ったリスト
     */
    public List<Hotel> findByPrice(int price) {
        List<Hotel> hotels = hotelRepository.findByPrice(price);
        return hotels;
    }
}
