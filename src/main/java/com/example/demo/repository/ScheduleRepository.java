package com.example.demo.repository;

import com.example.demo.entity.ScheduleSEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleSEntity, Long> {
    // Các phương thức truy vấn tùy chỉnh có thể được định nghĩa ở đây
    // Ví dụ: Optional<ScheduleEntity> findByCourseId(Long courseId);
}
