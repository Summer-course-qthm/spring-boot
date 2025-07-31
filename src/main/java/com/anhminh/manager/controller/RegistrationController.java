package com.anhminh.manager.controller;

import com.anhminh.manager.entity.RegistrationEntity;
import com.anhminh.manager.service.RegistrationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/dangki")
@RestController
public class RegistrationController {

    @Autowired
    private RegistrationsService registrationsService;

    @GetMapping
    public List<RegistrationEntity> getAllSRe() {
        return registrationsService.getAllRe();
    }

    // POST: tạo đăng ký mới
    @PostMapping("/create")
    public RegistrationEntity createRegistration(RegistrationEntity registration) {
        return registrationsService.createRegistration(registration);
    }

    // PUT: cập nhật thông tin đăng ký
    @PutMapping("{id}")
    public RegistrationEntity updateRegistration(@PathVariable int id, @RequestBody RegistrationEntity registrationDetails) {
        return registrationsService.updateRegistration(id, registrationDetails);
    }

    // DELETE: Xoá đăng ký
    @DeleteMapping("{id}")
    public void deleteRegistration(@PathVariable int id) {
        registrationsService.deleteRegistration(id);
    }

}
