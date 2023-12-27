package com.anth0o0ny.backend.enums;

public enum PoolSize {

    FiftyMeters ("50 метров"),
    TwentyFiveMeters ("25 метров");

    private final String title;

    PoolSize(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
