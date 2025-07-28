package com.anhminh.manager.service;

import com.anhminh.manager.entity.StudentEntity;
import com.anhminh.manager.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;

    //get all sinh vien
    public List<StudentEntity> getAllStudents() {
        return studentsRepository.findAll();
    }
}
