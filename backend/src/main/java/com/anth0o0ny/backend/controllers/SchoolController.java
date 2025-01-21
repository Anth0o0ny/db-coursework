package com.anth0o0ny.backend.controllers;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.dto.entitiesDto.SportschoolDto;
import com.anth0o0ny.backend.entities.Sportschool;
import com.anth0o0ny.backend.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.SPORTS_SCHOOLS_PATH)
public class SchoolController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/{"+ Constants.SPORTS_SCHOOLS_NAME_PATH + "}")
    public List<SportschoolDto> getSchoolByName(@PathVariable(Constants.SPORTS_SCHOOLS_NAME_PATH) String name) {
        return schoolService.getSchoolByName(name);
    }
}
