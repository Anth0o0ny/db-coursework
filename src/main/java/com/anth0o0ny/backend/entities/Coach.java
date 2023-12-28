package com.anth0o0ny.backend.entities;

import com.anth0o0ny.backend.enums.Rank;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Coach extends Person {

    private Date yob;
    private int sportschoolId;
    public Coach() {
        super();
    }

    public Coach(int id, String fullName, Date yob, int sportschoolId) {
        super(id, fullName);
        this.yob = yob;
        this.sportschoolId = sportschoolId;
    }

    //  incorrect yob data
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    public Date getYob() {
        return yob;
    }

    public void setYob(Date yob) {
        this.yob = yob;
    }

    public int getSportschoolId() {
        return sportschoolId;
    }

    public void setSportschoolId(int sportschoolId) {
        this.sportschoolId = sportschoolId;
    }
}
