package com.example.riadhfarhati.messagati;

/**
 * Created by i on 06/06/2017.
 */

public class msg {
    int id;
    String text;

    public msg(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
