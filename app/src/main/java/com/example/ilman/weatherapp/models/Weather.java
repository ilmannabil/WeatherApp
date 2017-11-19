package com.example.ilman.weatherapp.models;

/**
 * Created by ilman on 19/11/2017.
 */

public class Weather {

    private String date;
    private String time;
    private Double tempMax;
    private Double tempMin;
    private String weatherName;
    private String city;
    private String country;

    public Weather(String date, String time, Double tempMax, Double tempMin, String weatherName, String city, String country) {
        this.date = date;
        this.time = time;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.weatherName = weatherName;
        this.city = city;
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public String getWeatherName() {
        return weatherName;
    }

    public void setWeatherName(String weatherName) {
        this.weatherName = weatherName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
