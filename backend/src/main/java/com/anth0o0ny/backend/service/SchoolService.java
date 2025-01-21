package com.anth0o0ny.backend.service;

import com.anth0o0ny.backend.database.DB;
import com.anth0o0ny.backend.dto.entitiesDto.SportschoolDto;
import com.anth0o0ny.backend.dto.mapper.SportschoolMapper;
import com.anth0o0ny.backend.entities.Sportschool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final DB db;

    @Autowired
    public SchoolService(DB db) {
        this.db = db;
    }

    public List<SportschoolDto> getSchoolByName(String name) {
        List<Sportschool> schools = db.getSchoolByName(name);
        return schools.stream()
                .map(SportschoolMapper::toDto)
                .collect(Collectors.toList());
    }
}
