package com.anhminh.manager.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "students")
@Getter
@Setter

public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true) //Chi co duy nhat mot email
    private String name;
    private String email;

    @CreationTimestamp // Gan thoi gian khi tao moi
    @Column(updatable = false) // Khong cho phep cap nhat
    private Timestamp created_at;

}
