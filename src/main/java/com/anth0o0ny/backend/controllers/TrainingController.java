package com.anth0o0ny.backend.controllers;

import com.anth0o0ny.backend.entities.Training;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/training")
public class TrainingController {

    @PostMapping("/getTrainings")
    public List<Training> getTrainings() {
        return new ArrayList<>();
    }

}
