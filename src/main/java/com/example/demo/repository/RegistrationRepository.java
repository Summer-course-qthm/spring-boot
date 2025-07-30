package com.example.demo.repository;

import com.example.demo.entity.RegistrationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationsEntity, Long> {
    // Các phương thức truy vấn tùy chỉnh có thể được định nghĩa ở đây
    // Ví dụ: Optional<RegistrationEntity> findByStudentId(Long studentId);
}
