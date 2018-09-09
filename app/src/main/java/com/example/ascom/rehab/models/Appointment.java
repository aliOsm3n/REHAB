package com.example.ascom.rehab.models;

public class Appointment {

    String img ;
    String name ;
    String Specialization ;
    String Rate ;
    String day ;
    String time ;
    String salary ;
    String address ;


    public Appointment(String img, String name, String specialization, String rate, String day, String time, String salary, String address) {
        this.img = img;
        this.name = name;
        Specialization = specialization;
        Rate = rate;
        this.day = day;
        this.time = time;
        this.salary = salary;
        this.address = address;
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

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public String getSalary() {
        return salary;
    }

    public String getAddress() {
        return address;
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

    public void setDay(String day) {
        this.day = day;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
