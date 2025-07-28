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

    // Thêm sinh viên mới
    public StudentEntity createStudent(StudentEntity student) {
        return studentsRepository.save(student);
    }

    // Cập nhật sinh viên
    public StudentEntity updateStudent(int id, StudentEntity studentDetails) {
        StudentEntity student = studentsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student không tồn tại: " + id));

        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());

        return studentsRepository.save(student);
    }

    // Xoá sinh viên
    public void deleteStudent(int id) {
        studentsRepository.deleteById(id);
    }

}
