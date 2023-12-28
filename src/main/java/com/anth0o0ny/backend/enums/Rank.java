//package com.anth0o0ny.backend.enums;
//
//public enum Rank {
//
//    ThirdRank ("IIIю"),
//    SecondRank ("IIю"),
//    FirstRank ("I"),
//    ThirdAdultRank ("III"),
//    SecondAdultRank ("II"),
//    FirstAultRank ("I"),
//    CandidateOfMaster ("КМС"),
//    Master ("МС");
//
//    private final String title;
//
//    Rank(String title) {
//        this.title = title;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//}

package com.anth0o0ny.backend.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Rank {
    MS("МС"), CMS("КМС"), I_A("I"), II_A("II"), III_A("III"), I_Y("Iю"), II_Y("IIю"), III_Y("IIIю"), NR("Отсутствует");

    private final String title;

    Rank(String title) {
        this.title = title;
    }

    @JsonValue
    public String getTitle() {
        return title;
    }
}