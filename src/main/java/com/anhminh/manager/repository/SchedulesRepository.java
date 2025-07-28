package com.anhminh.manager.repository;

import com.anhminh.manager.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulesRepository extends JpaRepository<ScheduleEntity, Integer>{
}
