package com.example.hoche.repository;

import com.example.hoche.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    @Query(value = "SELECT * FROM student WHERE std_age BETWEEN :minAge AND :maxAge", nativeQuery = true)
    List<StudentEntity> findStudentsByAgeBetween(@Param("minAge") int minAge, @Param("maxAge") int maxAge);
}
