package com.example.demo.repository;

import com.example.demo.entity.RegistrationsEntity;
import com.example.demo.entity.ScheduleSEntity;
import com.example.demo.entity.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationsEntity, Long> {
    // Các phương thức truy vấn tùy chỉnh có thể được định nghĩa ở đây

    @Query("SELECT r.student FROM RegistrationsEntity r WHERE r.course.id = :courseId")
    List<StudentsEntity> findStudentsByCourseId(@Param("courseId") Long courseId);

    // lấy tất cả lịch học mà cua rsinh viên
    @Query("""
        SELECT s 
        FROM ScheduleSEntity s
        JOIN s.course c
        JOIN RegistrationsEntity r ON r.course.id = c.id
        WHERE r.student.id = :studentId
    """)
    List<ScheduleSEntity> findSchedulesByStudentId(@Param("studentId") Long studentId);

}
