package com.anhminh.manager.repository;

import com.anhminh.manager.entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationsRepository extends JpaRepository<RegistrationEntity, Integer>{
}
