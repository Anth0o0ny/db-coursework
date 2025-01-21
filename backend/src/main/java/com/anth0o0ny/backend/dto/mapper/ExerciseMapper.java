package com.anth0o0ny.backend.dto.mapper;

import com.anth0o0ny.backend.dto.entitiesDto.ExerciseDto;
import com.anth0o0ny.backend.entities.Exercise;

public class ExerciseMapper {
    public static ExerciseDto toDto(Exercise exercise) {
        return new ExerciseDto(exercise.getId(), exercise.getDescription(), exercise.getCount());
    }
}
