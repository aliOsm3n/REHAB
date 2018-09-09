package com.example.ascom.rehab.models;

import java.util.Date;

public class Msg {

    String Name ;
    String date;
    String messegs;

    public Msg(String name, String date, String messegs) {
        Name = name;
        this.date = date;
        this.messegs = messegs;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMessegs(String messegs) {
        this.messegs = messegs;
    }

    public String getName() {
        return Name;
    }

    public String getDate() {
        return date;
    }

    public String getMessegs() {
        return messegs;
    }
}
