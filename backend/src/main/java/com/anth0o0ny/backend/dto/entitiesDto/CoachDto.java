package com.anth0o0ny.backend.dto.entitiesDto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CoachDto extends PersonDto {
    private Date yob;
    private int sportschoolId;

    public CoachDto(int id, String fullName, Date yob, int sportschoolId) {
        super(id, fullName);
        this.yob = yob;
        this.sportschoolId = sportschoolId;
    }
}
