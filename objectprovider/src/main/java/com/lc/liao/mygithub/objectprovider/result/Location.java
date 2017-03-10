package com.lc.liao.mygithub.objectprovider.result;

import android.text.TextUtils;

import com.lc.liao.mygithub.objectprovider.result.pub.City;

import java.io.Serializable;

/**
 * Created by liao on 2017/3/9.
 *
 * 该类也是基于现在的项目弄的，如果要用可以根据实际情况处理
 */

public class Location implements Serializable{
    /**
     * 城市
     */
    private City city;
    /**
     * 经度
     */
    private double lng;
    /**
     * 维度
     */
    private double lat;
    /**
     * 街道地址
     */
    private String street;

    public Location(){

    }

    public Location(City city, double longitude, double latitude, String address) {
        this.city = city;
        this.lng = longitude;
        this.lat = latitude;
        this.street = address;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    /**
     * 是否是有效位置
     *
     * @return true 有效 false无效
     */
    public boolean isValid() {
        return !(city == null || TextUtils.isEmpty(city.code) || city.code.length() == 1 || TextUtils.isEmpty(city.name) || lat <= 0 || lng <= 0 || TextUtils.isEmpty(street));
    }

    /**
     * 仅供lp用
     *
     * @return
     */
    public String getAddress() {
        String cityName = city != null ? city.name : "";
        return cityName + " " + street;
    }

    @Override
    public String toString() {
        String cityStr = city != null ? (city.name + " " + city.code) : "null";
        return "Location{" +
                "city=" + cityStr +
                ", lng=" + lng +
                ", lat=" + lat +
                ", street='" + street + '\'' +
                '}';
    }
}
