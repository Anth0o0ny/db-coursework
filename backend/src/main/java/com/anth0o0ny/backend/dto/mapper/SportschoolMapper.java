package com.anth0o0ny.backend.dto.mapper;

import com.anth0o0ny.backend.dto.entitiesDto.SportschoolDto;
import com.anth0o0ny.backend.entities.Sportschool;

public class SportschoolMapper {
    public static SportschoolDto toDto(Sportschool sportschool) {
        return new SportschoolDto(
                sportschool.getId(),
                sportschool.getName(),
                sportschool.getPoolSize() != null ? sportschool.getPoolSize().name() : null
        );
    }
}
