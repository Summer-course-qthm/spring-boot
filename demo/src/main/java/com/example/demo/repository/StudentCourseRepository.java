package com.example.demo.repository;

import com.example.demo.entity.StudentCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepository extends JpaRepository<StudentCourseEntity, Long> {
    long countByCourseId(Long courseId); // countBy findBy+property
}
