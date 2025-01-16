package com.anth0o0ny.backend.entities;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.enums.Rank;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Setter;

import java.util.Date;

public class Sportsman extends Person {

    private Date yob;
    private Rank rank;
    private int sportschoolId;

    public Sportsman(int id, String fullName, Date yob, Rank rank, int sportschoolId) {
        super(id, fullName);
        this.yob = yob;
        this.rank = rank;
        this.sportschoolId = sportschoolId;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATA_PATTERN, timezone = Constants.UTC_TIME_ZONE)
    public Date getYob() {
        return yob;
    }

    public Rank getRank() {
        return rank;
    }

    public int getSportschoolId() {
        return sportschoolId;
    }

    public void setYob(Date yob) {
        this.yob = yob;
    }

    public void setSportschoolId(int sportschoolId) {
        this.sportschoolId = sportschoolId;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
