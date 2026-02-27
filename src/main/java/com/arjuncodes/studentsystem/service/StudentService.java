package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.entity.Student;
import com.arjuncodes.studentsystem.dto.student.StudentDto;
import com.arjuncodes.studentsystem.dto.student.StudentResponseDto;
import com.arjuncodes.studentsystem.exception.model.ResourceNotFoundException;
import com.arjuncodes.studentsystem.mapper.StudentMapper;
import com.arjuncodes.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper mapper;

    public List<StudentResponseDto> listStudents() {
        List<Student> students = studentRepository.findAll();

        return mapper.toDtoList(students);
    }

    public StudentResponseDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new ResourceNotFoundException("Student not found" + studentId));

        return mapper.toDto(student);
    }

    public void createStudent(StudentDto student) {
        Student studentEntity = mapper.toEntity(student);
        studentRepository.save(studentEntity);
    }

    public void updateStudent(Long studentId, StudentDto payload) {
        Student existingStudent = studentRepository.findById(studentId)
            .orElseThrow(() -> new ResourceNotFoundException("Student not found id: " + studentId));
        mapper.updateEntityFromDto(existingStudent, payload);

        studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new ResourceNotFoundException("Student not found id: " + studentId);
        }
        studentRepository.deleteById(studentId);
    }
}
