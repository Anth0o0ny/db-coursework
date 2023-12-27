package com.anth0o0ny.backend.entities;

import com.anth0o0ny.backend.enums.Rank;

public class Sportsman extends Person {

    private Rank rank;

    public Sportsman() {
        super();
    }

    public Sportsman(int id, String fullName) {
        super(id, fullName);
    }

    public Sportsman(int id, String fullName, Rank rank) {
        super(id, fullName);
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
