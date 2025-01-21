package com.anth0o0ny.backend.dto.mapper;

import com.anth0o0ny.backend.dto.entitiesDto.CompetitionDto;
import com.anth0o0ny.backend.entities.Competition;

public class CompetitionMapper {
    public static CompetitionDto toDto(Competition competition) {
        return new CompetitionDto(
                competition.getId(),
                competition.getName(),
                competition.getPoolName(),
                competition.getStartDate(),
                competition.getEndDate(),
                competition.getDistance() != null ? competition.getDistance().getTitle() : null
        );
    }
}
