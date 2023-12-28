package com.anth0o0ny.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PoolSize {

    _50 ("50 метров"),
    _25 ("25 метров");

    private final String title;

    PoolSize(String title) {
        this.title = title;
    }

    @JsonValue
    public String getTitle() {
        return title;
    }

    @JsonCreator
    public static PoolSize fromTitle(String title) {
        for (PoolSize poolSize : values()) {
            if (poolSize.title.equals(title)) {
                return poolSize;
            }
        }
        return null;
    }
}
