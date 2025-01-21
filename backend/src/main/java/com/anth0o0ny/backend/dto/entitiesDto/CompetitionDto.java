package com.anth0o0ny.backend.dto.entitiesDto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CompetitionDto {
    private int id;
    private String name;
    private String poolName;
    private Date startDate;
    private Date endDate;
    private String distance;

    public CompetitionDto(int id, String name, String poolName, Date startDate, Date endDate, String distance) {
        this.id = id;
        this.name = name;
        this.poolName = poolName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.distance = distance;
    }
}
