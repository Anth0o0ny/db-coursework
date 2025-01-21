package com.anth0o0ny.backend.dto.entitiesDto;

import com.anth0o0ny.backend.Constants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CompetitionDto {
    private int id;
    @Size(min = 3, max = 100, message = Constants.ERROR_COMPETITION_NAME_SIZE)
    private String name;

    @NotNull(message = Constants.ERROR_POOL_NAME_NULL)
    private String poolName;

    private Date startDate;
    private Date endDate;

    @NotNull(message = Constants.ERROR_DISTANCE_NULL)
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
