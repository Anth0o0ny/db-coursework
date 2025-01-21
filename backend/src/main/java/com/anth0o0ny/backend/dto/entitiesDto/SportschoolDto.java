package com.anth0o0ny.backend.dto.entitiesDto;

import com.anth0o0ny.backend.Constants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SportschoolDto {
    private int id;

    @NotNull(message = Constants.ERROR_SCHOOL_NAME_NULL)
    @Size(min = 3, max = 100, message = Constants.ERROR_SCHOOL_NAME_SIZE)
    private String name;

    @NotNull(message = Constants.ERROR_LOCATION_NULL)
    @Size(min = 3, max = 100, message = Constants.ERROR_LOCATION_SIZE)
    private String location;

    public SportschoolDto(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }
}
