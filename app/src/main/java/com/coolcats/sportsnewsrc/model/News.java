package com.coolcats.sportsnewsrc.model;

import com.coolcats.sportsnewsrc.Sport;

import java.io.Serializable;

public class News implements Serializable {

    private Sport sport;
    private String headLine;
    private String date;


    public News(Sport sport, String headLine, String date) {
        this.sport = sport;
        this.headLine = headLine;
        this.date = date;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public String getHeadLine() {
        return headLine;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "News{" +
                "sport=" + sport +
                ", headLine='" + headLine + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
