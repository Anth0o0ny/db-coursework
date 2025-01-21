package com.anth0o0ny.backend.dto.entitiesDto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TrainingWithExercisesDto {
    private int id;
    private int coachId;
    private int sportsmanId;
    private List<ExerciseDto> exercises;

    public TrainingWithExercisesDto(int id, int coachId, int sportsmanId, List<ExerciseDto> exercises) {
        this.id = id;
        this.coachId = coachId;
        this.sportsmanId = sportsmanId;
        this.exercises = exercises;
    }
}
