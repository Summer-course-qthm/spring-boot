package com.anhminh.manager.service;

import com.anhminh.manager.entity.RegistrationEntity;
import com.anhminh.manager.repository.RegistrationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationsService {
    @Autowired
    private RegistrationsRepository registrationsRepository;

    //get all dang ki
    public List<RegistrationEntity> getAllRe() {
        return registrationsRepository.findAll();
    }
}
