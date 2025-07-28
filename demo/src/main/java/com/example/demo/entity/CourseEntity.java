package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "courses")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "std_name")
    private String name;

    @Column(name = "description") //Chi ro no la dinh dang TEXT
    private String description;

    @CreationTimestamp // Gan thoi gian khi tao moi
    @Column(name = "created_at",updatable = false) // Khong cho phep cap nhat
    private Timestamp created_at;

}
