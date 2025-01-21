package com.anth0o0ny.backend.dto.mapper;

import com.anth0o0ny.backend.dto.entitiesDto.CoachDto;
import com.anth0o0ny.backend.dto.entitiesDto.PersonDto;
import com.anth0o0ny.backend.dto.entitiesDto.SportsmanDto;
import com.anth0o0ny.backend.entities.Coach;
import com.anth0o0ny.backend.entities.Person;
import com.anth0o0ny.backend.entities.Sportsman;

public class PersonMapper {
    public static PersonDto toDto(Person person) {
        return new PersonDto(person.getId(), person.getFullName());
    }

    public static CoachDto toDto(Coach coach) {
        return new CoachDto(coach.getId(), coach.getFullName(), coach.getYob(), coach.getSportschoolId());
    }

    public static SportsmanDto toDto(Sportsman sportsman) {
        return new SportsmanDto(sportsman.getId(), sportsman.getFullName(), sportsman.getYob(), sportsman.getRank().getTitle(), sportsman.getSportschoolId());
    }
}

