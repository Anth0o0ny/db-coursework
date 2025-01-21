package com.anth0o0ny.backend.dto.entitiesDto;

import com.anth0o0ny.backend.Constants;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TrainingWithExercisesDto {
    private int id;

    @NotNull(message = Constants.ERROR_COACH_ID_NULL)
    private int coachId;

    @NotNull(message = Constants.ERROR_SPORTSMAN_ID_NULL)
    private int sportsmanId;

    @NotNull(message = Constants.ERROR_EXERCISES_NULL)
    private List<ExerciseDto> exercises;

    public TrainingWithExercisesDto(int id, int coachId, int sportsmanId, List<ExerciseDto> exercises) {
        this.id = id;
        this.coachId = coachId;
        this.sportsmanId = sportsmanId;
        this.exercises = exercises;
    }
}
