package com.anhminh.manager.repository;

import com.anhminh.manager.entity.CourseEntity;
import com.anhminh.manager.entity.RegistrationEntity;
import com.anhminh.manager.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegistrationsRepository extends JpaRepository<RegistrationEntity, Integer> {

    boolean existsByStudentAndCourse(StudentEntity student, CourseEntity course);

    @Query("SELECT r FROM RegistrationEntity r JOIN FETCH r.student s WHERE r.course.id = :courseId")
    List<RegistrationEntity> findAllCoursebyDangki(@Param("courseId") Integer courseId);

    @Query("SELECT r FROM RegistrationEntity r JOIN FETCH r.student JOIN FETCH r.course")
    List<RegistrationEntity> findAllWithDetails();

    @Query("SELECT r FROM RegistrationEntity r WHERE r.student.id = :studentId")
    List<RegistrationEntity> findAllWithDetailsByStudentId(@Param("studentId") Integer studentId);

    @Query("SELECT r FROM RegistrationEntity r " +
            "JOIN FETCH r.course c " +
            "LEFT JOIN FETCH c.schedules s " + // LEFT JOIN để lấy cả những course chưa có lịch
            "WHERE r.student.id = :studentId")
    List<RegistrationEntity> findFullCoursesByStudentId(@Param("studentId") Integer studentId);
}