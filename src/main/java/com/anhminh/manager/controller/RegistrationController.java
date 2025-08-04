// File: src/main/java/com/anhminh/manager/controller/RegistrationController.java
package com.anhminh.manager.controller;

import com.anhminh.manager.DTO.request.RegistrationRequest;
import com.anhminh.manager.DTO.response.CourseWithStudentsResponse;
import com.anhminh.manager.DTO.response.RegistrationResponse;
import com.anhminh.manager.service.RegistrationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dangki")
public class RegistrationController {

    @Autowired
    private RegistrationsService registrationsService;

    @GetMapping
    public ResponseEntity<List<RegistrationResponse>> getAllRegistrations() {
        return ResponseEntity.ok(registrationsService.getAllRegistrations());
    }

    @PostMapping
    public ResponseEntity<RegistrationResponse> createRegistration(@RequestBody RegistrationRequest request) {
        RegistrationResponse newRegistration = registrationsService.createRegistration(request);
        return new ResponseEntity<>(newRegistration, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistrationResponse> updateRegistration(@PathVariable int id, @RequestBody RegistrationRequest request) {
        RegistrationResponse updatedRegistration = registrationsService.updateRegistration(id, request);
        return ResponseEntity.ok(updatedRegistration);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistration(@PathVariable int id) {
        registrationsService.deleteRegistration(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/course/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseWithStudentsResponse> getCourseWithStudents(@PathVariable Integer courseId) {
        CourseWithStudentsResponse response = registrationsService.getCourseWithRegisteredStudents(courseId);
        return ResponseEntity.ok(response);
    }
}