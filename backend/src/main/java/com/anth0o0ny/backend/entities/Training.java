package com.anth0o0ny.backend.entities;


public class Training {
    private int id;
    private int coachId;
    private int sportsmanId;



    // геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public int getSportsmanId() {
        return sportsmanId;
    }

    public void setSportsmanId(int sportsmanId) {
        this.sportsmanId = sportsmanId;
    }
}

