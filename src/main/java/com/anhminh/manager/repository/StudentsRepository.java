package com.anhminh.manager.repository;

import com.anhminh.manager.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends JpaRepository<StudentEntity, Integer> {
    // Spring Data JPA sẽ tự động tạo các phương thức CRUD cho bạn
    // findAll(), findById(), save(), delete(), ...
}