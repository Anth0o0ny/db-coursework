package com.anth0o0ny.backend.dto.entitiesDto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SportsmanDto extends PersonDto {
    private Date yob;
    private String rank;
    private int sportschoolId;

    public SportsmanDto(int id, String fullName, Date yob, String rank, int sportschoolId) {
        super(id, fullName);
        this.yob = yob;
        this.rank = rank;
        this.sportschoolId = sportschoolId;
    }
}
