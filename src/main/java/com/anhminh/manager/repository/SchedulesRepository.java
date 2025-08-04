package com.anhminh.manager.repository;

import com.anhminh.manager.entity.CourseEntity;
import com.anhminh.manager.entity.RegistrationEntity;
import com.anhminh.manager.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchedulesRepository extends JpaRepository<ScheduleEntity, Integer>{
    List<ScheduleEntity> findAllByCourse(CourseEntity course);

    @Query("""
        SELECT s FROM RegistrationEntity r
        JOIN r.course c
        JOIN c.schedules s
        WHERE r.student.id = :studentId
        ORDER BY c.name
    """)
    List<ScheduleEntity> findSchedulesByStudentId(@Param("studentId") Integer studentId);
}
