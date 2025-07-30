package com.example.demo.repository;

import com.example.demo.entity.CoursesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CoursesEntity, Long> {
    // Các phương thức truy vấn tùy chỉnh có thể được định nghĩa ở đây
    // Ví dụ: Optional<CourseEntity> findByName(String name);
}
