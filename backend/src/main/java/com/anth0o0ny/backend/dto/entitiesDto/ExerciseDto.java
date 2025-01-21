package com.anth0o0ny.backend.dto.entitiesDto;

import com.anth0o0ny.backend.Constants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseDto {
    private int id;

    @NotNull(message = Constants.ERROR_DESCRIPTION_NULL)
    @Size(min = 3, max = 255, message = Constants.ERROR_DESCRIPTION_SIZE)
    private String description;

    @NotNull(message = Constants.ERROR_COUNT_NULL)
    private int count;

    public ExerciseDto(int id, String description, int count) {
        this.id = id;
        this.description = description;
        this.count = count;
    }
}
