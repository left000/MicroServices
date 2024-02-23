package com.microservice.course.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDTO {

    private String name;
    private String lastName;
    private String email;
    private Long courseId;
}
