package com.microservice.course.controller;

import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Course saveCourse(@RequestBody Course course ){
        return courseService.save(course);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAll() {
        List<Course> courses = courseService.findAll();
        if (courses.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(courses);
        }
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Course> findById(@PathVariable("id") Long id){
        Course course = courseService.findById(id);
        if (course == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(course);
        }
    }

    @GetMapping("/search-student/{idCourse}")
    public ResponseEntity<StudentByCourseResponse> findStudentsByIdCourse(@PathVariable("idCourse") Long idCourse){
        StudentByCourseResponse studentByCourseResponse = courseService.findStudentsByIdCourse(idCourse);
        if (studentByCourseResponse == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(studentByCourseResponse);
        }
    }
}
