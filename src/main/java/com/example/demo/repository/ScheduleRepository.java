package com.example.demo.repository;

import com.example.demo.entity.CoursesEntity;
import com.example.demo.entity.ScheduleSEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleSEntity, Long> {
    List<ScheduleSEntity> findAllByCourse(CoursesEntity course);

}
