package com.arjuncodes.studentsystem.controller;

import com.arjuncodes.studentsystem.dto.student.StudentDto;
import com.arjuncodes.studentsystem.dto.base.Response;
import com.arjuncodes.studentsystem.dto.student.StudentResponseDto;
import com.arjuncodes.studentsystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<Response> listStudents() {
        List<StudentResponseDto> students = studentService.listStudents();

        return ResponseEntity.status(HttpStatus.OK)
            .body(Response.success("200", "success", "successfully list students", students));
    }

    @GetMapping("/{stu_id}")
    public ResponseEntity<Response> getStudentById(@PathVariable("stu_id") Long studentId) {
        StudentResponseDto student = studentService.getStudentById(studentId);

        return ResponseEntity.status(HttpStatus.OK)
            .body(Response.success("200", "success", "successfully retrieve student", student));
    }

    @PostMapping
    public ResponseEntity<Response> createStudent(@Valid @RequestBody StudentDto payload) {
        studentService.createStudent(payload);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(Response.success("201", "success", "successfully created student"));
    }

    @PutMapping("/{stu_id}")
    public ResponseEntity<Response> updateStudent(@PathVariable("stu_id") Long studentId, @RequestBody StudentDto payload) {
        studentService.updateStudent(studentId, payload);

        return ResponseEntity.status(HttpStatus.OK)
            .body(Response.success("200", "success", "successfully updated student", payload));
    }

    @DeleteMapping("/{stu_id}")
    public ResponseEntity<Response> deleteStudent(@PathVariable Long stu_id) {
        studentService.deleteStudent(stu_id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .body(Response.success("200", "success", "successfully deleted student with id: " + stu_id));
    }
}
