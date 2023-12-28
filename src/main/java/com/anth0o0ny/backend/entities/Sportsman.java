package com.anth0o0ny.backend.entities;

import com.anth0o0ny.backend.enums.Rank;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Sportsman extends Person {

    private Date yob;
    private Rank rank;
    private int sportschoolId;

    public Sportsman() {
        super();
    }


    public Sportsman(int id, String fullName, Date yob, Rank rank, int sportschoolId) {
        super(id, fullName);
        this.yob = yob;
        this.rank = rank;
        this.sportschoolId = sportschoolId;
    }

    public int getSportschoolId() {
        return sportschoolId;
    }


    //  incorrect yob data
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    public Date getYob() {
        return yob;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setYob(Date yob) {
        this.yob = yob;
    }

    public void setSportschoolId(int sportschoolId) {
        this.sportschoolId = sportschoolId;
    }
}
