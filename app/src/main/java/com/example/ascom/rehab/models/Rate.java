package com.example.ascom.rehab.models;

public class Rate {

    String name ;
    String date ;
    String Rate ;
    String description;


    public Rate(String name, String date, String rate, String description) {
        this.name = name;
        this.date = date;
        Rate = rate;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getRate() {
        return Rate;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRate(String rate) {
        Rate = rate;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
