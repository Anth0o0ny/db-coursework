package com.anth0o0ny.backend.dto.entitiesDto;

import com.anth0o0ny.backend.Constants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDto {
    private int id;

    @NotNull(message = Constants.ERROR_FULL_NAME_NULL)
    @Size(min = 3, max = 100, message = Constants.ERROR_FULL_NAME_SIZE)
    private String fullName;

    public PersonDto(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
}
