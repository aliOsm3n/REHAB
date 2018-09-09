package com.example.ascom.rehab.models;

public class Favourite {

    String img ;
    String name ;
    String Specialization ;
    String Rate ;
    String descreption ;


    public Favourite(String img, String name, String specialization, String rate, String descreption) {
        this.img = img;
        this.name = name;
        Specialization = specialization;
        Rate = rate;
        this.descreption = descreption;
    }

    public Favourite(String img, String name, String specialization, String descreption) {
        this.img = img;
        this.name = name;
        Specialization = specialization;
        this.descreption = descreption;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public void setRate(String rate) {
        Rate = rate;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public String getRate() {
        return Rate;
    }

    public String getDescreption() {
        return descreption;
    }
}
