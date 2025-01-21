package com.anth0o0ny.backend.dto.mapper;

import com.anth0o0ny.backend.dto.entitiesDto.ExerciseDto;
import com.anth0o0ny.backend.dto.entitiesDto.TrainingWithExercisesDto;
import com.anth0o0ny.backend.entities.TrainingWithExercises;

import java.util.List;
import java.util.stream.Collectors;

public class TrainingWithExercisesMapper {
    public static TrainingWithExercisesDto toDto(TrainingWithExercises training) {
        List<ExerciseDto> exercises = training.getExercises().stream()
                .map(ExerciseMapper::toDto)
                .collect(Collectors.toList());

        return new TrainingWithExercisesDto(
                training.getId(),
                training.getCoachId(),
                training.getSportsmanId(),
                exercises
        );
    }
}
