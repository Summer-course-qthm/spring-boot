package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;


import java.sql.Timestamp;


@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "st_name")
    private String name;

    @Column(name = "std_email",unique = true)//Chi co duy nhat mot email
    private String email;

    @CreationTimestamp // Gan thoi gian khi tao moi
    @Column(name = "created_at",updatable = false) // Khong cho phep cap nhat
    private Timestamp created_at;

}