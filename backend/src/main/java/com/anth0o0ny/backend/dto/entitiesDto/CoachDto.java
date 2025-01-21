package com.anth0o0ny.backend.dto.entitiesDto;

import com.anth0o0ny.backend.Constants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CoachDto extends PersonDto {
    @Past(message = Constants.ERROR_YOB_PAST)
    private Date yob;

    @NotNull(message = Constants.ERROR_SCHOOL_ID_NULL)
    private int sportschoolId;

    public CoachDto(int id, String fullName, Date yob, int sportschoolId) {
        super(id, fullName);
        this.yob = yob;
        this.sportschoolId = sportschoolId;
    }
}
