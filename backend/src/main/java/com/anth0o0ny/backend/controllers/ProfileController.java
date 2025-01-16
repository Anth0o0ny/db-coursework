package com.anth0o0ny.backend.controllers;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.PROFILES_PATH)
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping(Constants.PROFILE_PATH)
    public String getInfo(@PathVariable(Constants.USER_ID) String userId) {
        return profileService.getUserInfo(userId);
    }
}

