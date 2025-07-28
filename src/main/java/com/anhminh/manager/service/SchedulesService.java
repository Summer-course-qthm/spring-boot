package com.anhminh.manager.service;

import com.anhminh.manager.entity.ScheduleEntity;
import com.anhminh.manager.repository.SchedulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulesService {
    @Autowired
    private SchedulesRepository schedulesRepository;

    //get all lich hoc
    public List<ScheduleEntity> getAllSchedules() {
        return schedulesRepository.findAll();
    }
}
