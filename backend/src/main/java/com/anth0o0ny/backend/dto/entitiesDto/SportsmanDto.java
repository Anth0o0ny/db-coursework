package com.anth0o0ny.backend.dto.entitiesDto;

import com.anth0o0ny.backend.Constants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SportsmanDto extends PersonDto {
    @Past(message = Constants.ERROR_YOB_PAST_DATE)
    private Date yob;

    @NotNull(message = Constants.ERROR_RANK_NULL)
    private String rank;

    @NotNull(message = Constants.ERROR_SPORTSCHOOL_ID_NULL)
    private int sportschoolId;

    public SportsmanDto(int id, String fullName, Date yob, String rank, int sportschoolId) {
        super(id, fullName);
        this.yob = yob;
        this.rank = rank;
        this.sportschoolId = sportschoolId;
    }
}
