package com.anth0o0ny.backend.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Distance {
    _50_BUTTERFLY("50 butterfly"),
    _50_BACKSTROKE("50 backstroke"),
    _50_BREASTSTROKE("50 breaststroke"),
    _50_FREESTYLE("50 freestyle"),
    _100_BUTTERFLY("100 butterfly"),
    _100_BACKSTROKE("100 backstroke"),
    _100_BREASTSTROKE("100 breaststroke"),
    _100_MEDLEY("100 medley"),
    _100_FREESTYLE("100 freestyle"),
    _200_BUTTERFLY("200 butterfly"),
    _200_BACKSTROKE("200 backstroke"),
    _200_BREASTSTROKE("200 breaststroke"),
    _200_FREESTYLE("200 freestyle"),
    _200_MEDLEY("200 medley"),
    _400_FREESTYLE("400 freestyle"),
    _400_MEDLEY("400 medley"),
    _800_FREESTYLE("800 freestyle"),
    _1500_FREESTYLE("1500 freestyle");

    private final String title;

    Distance(String title) {
        this.title = title;
    }

    @JsonValue
    public String getTitle() {
        return title;
    }

    public static Distance fromTitle(String title) {
        for (Distance distance : Distance.values()) {
            if (distance.title.equalsIgnoreCase(title)) {
                return distance;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + title + "]");
    }
}
