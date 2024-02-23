package com.microservice.course.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String teacher;

}
