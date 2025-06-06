package com.example.domain;

/**
 * ホテルドメインを表すクラスです.
 *
 * @author takuto.itami
 */
public class Hotel {
    /** ID */
   private int id;
    /** エリア名 */
   private String areaName;
    /** ホテル名 */
   private String hotelName;
    /** 住所 */
   private String address;
    /** 最寄り駅 */
   private String nearestStation;
    /** 価格 */
   private int price;
    /** 駐車場の有無 */
   private String parking;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNearestStation() {
        return nearestStation;
    }

    public void setNearestStation(String nearestStation) {
        this.nearestStation = nearestStation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", areaName='" + areaName + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", address='" + address + '\'' +
                ", nearestStation='" + nearestStation + '\'' +
                ", price=" + price +
                ", parking='" + parking + '\'' +
                '}';
    }
}
