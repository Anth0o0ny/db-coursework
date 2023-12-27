package com.anth0o0ny.backend.enums;

public enum Rank {

    ThirdRank ("IIIю"),
    SecondRank ("IIю"),
    FirstRank ("I"),
    ThirdAdultRank ("III"),
    SecondAdultRank ("II"),
    FirstAultRank ("I"),
    CandidateOfMaster ("КМС"),
    Master ("МС");

    private final String title;

    Rank(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
