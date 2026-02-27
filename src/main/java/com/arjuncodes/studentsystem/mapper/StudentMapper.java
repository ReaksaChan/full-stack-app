package com.arjuncodes.studentsystem.mapper;

import com.arjuncodes.studentsystem.entity.Student;
import com.arjuncodes.studentsystem.dto.student.StudentDto;
import com.arjuncodes.studentsystem.dto.student.StudentResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapper {
    public Student toEntity(StudentDto dto) {
        Student entity = new Student();

        entity.setName(dto.getName());
        entity.setGender(dto.getGender());
        entity.setDob(dto.getDob());
        entity.setAddress(dto.getAddress());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());

        return entity;
    }

    public StudentResponseDto toDto(Student entity) {
        StudentResponseDto dto = new StudentResponseDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setGender(entity.getGender());
        dto.setDob(entity.getDob());
        dto.setAddress(entity.getAddress());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public List<StudentResponseDto> toDtoList(List<Student> entities) {
        if (entities == null || entities.isEmpty()) {
            return new ArrayList<>();
        }

        return entities.stream()
            .map(student -> this.toDto(student))
            .collect(Collectors.toList());
    }

    public void updateEntityFromDto(Student entity, StudentDto dto) {
        if(entity == null || entity.getId() == null) {
            return;
        }
        entity.setName(dto.getName());
        entity.setGender(dto.getGender());
        entity.setDob(dto.getDob());
        entity.setAddress(dto.getAddress());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
    }
}
