package com.anth0o0ny.backend.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @PostMapping("/getInfo")
    public void getInfo() {
        return ;
    }

}
