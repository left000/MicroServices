package com.microservice.course.service;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.persistence.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    private CourseRepository courseRepository;

        @Autowired
        private StudentClient studentClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }
    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }
    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }
    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {

        //Consultar el Curso
        Course course = courseRepository.findById(idCourse).orElse(null);
        // Obtener los estudiantes
        List<StudentDTO> studentDTOList = studentClient.findAllStudentByCourse(idCourse);

            return StudentByCourseResponse.builder()
                    .courseName(course.getName())
                    .teacher(course.getTeacher())
                    .studentDTOList(studentDTOList)
                    .build();

//        return new StudentByCourseResponse(course.getName(), course.getTeacher(), studentDTOList);

    }
}
