package com.microservice.course.http.response;

import com.microservice.course.dto.StudentDTO;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class StudentByCourseResponse {

    private String courseName;
    private String teacher;
    private List<StudentDTO> studentDTOList;


}
