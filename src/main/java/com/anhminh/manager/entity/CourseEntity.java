package com.anhminh.manager.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
@Getter
@Setter

public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @OneToMany(mappedBy = "course") // Giả sử bạn đã có quan hệ này
    @JsonManagedReference
    private Set<ScheduleEntity> schedules;

    private String name;

    @Column(columnDefinition = "TEXT") //Chi ro no la dinh dang TEXT
    private String description;

    @CreationTimestamp // Gan thoi gian khi tao moi
    @Column(updatable = false) // Khong cho phep cap nhat
    private Timestamp created_at;
}
