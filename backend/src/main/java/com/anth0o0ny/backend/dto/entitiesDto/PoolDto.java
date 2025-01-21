package com.anth0o0ny.backend.dto.entitiesDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PoolDto {
    private int id;
    private String name;
    private String location;

    public PoolDto(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }
}
