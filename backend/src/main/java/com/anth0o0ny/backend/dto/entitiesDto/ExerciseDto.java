package com.anth0o0ny.backend.dto.entitiesDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseDto {
    private int id;
    private String description;
    private int count;

    public ExerciseDto(int id, String description, int count) {
        this.id = id;
        this.description = description;
        this.count = count;
    }
}
