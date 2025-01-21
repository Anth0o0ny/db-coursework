package com.anth0o0ny.backend.dto.entitiesDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDto {
    private int id;
    private String fullName;

    public PersonDto(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
}
