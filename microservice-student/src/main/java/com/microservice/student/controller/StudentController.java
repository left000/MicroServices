package com.microservice.student.controller;

import com.microservice.student.entities.Student;
import com.microservice.student.service.IStudentService;
import com.microservice.student.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student saveStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAll(){
        return ResponseEntity.ok(studentService.findAll());
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<Student> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }
    @GetMapping("/search-my-course/{idCourse}")
    // --- Tipo di Ritorno ResponseEntity<List<Student>>
    public ResponseEntity<?> findByIdCourse(@PathVariable("idCourse") Long idCourse){
        return ResponseEntity.ok(studentService.findByIdCourse(idCourse));

    }
}
