package com.anhminh.manager.repository;

import com.anhminh.manager.entity.CourseEntity;
import com.anhminh.manager.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchedulesRepository extends JpaRepository<ScheduleEntity, Integer>{
    List<ScheduleEntity> findAllByCourse(CourseEntity course);
}
