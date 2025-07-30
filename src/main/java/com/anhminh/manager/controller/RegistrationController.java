package com.anhminh.manager.controller;

import com.anhminh.manager.entity.RegistrationEntity;
import com.anhminh.manager.service.RegistrationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class RegistrationController {

    @Autowired
    private RegistrationsService registrationsService;
    //Start Registrations
    @GetMapping("/regis")
    public List<RegistrationEntity> getAllSRe() {
        return registrationsService.getAllRe();
    }
    //End Registrations
}
