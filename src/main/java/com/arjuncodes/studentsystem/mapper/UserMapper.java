package com.arjuncodes.studentsystem.mapper;

import com.arjuncodes.studentsystem.dto.user.UpdateUserDto;
import com.arjuncodes.studentsystem.dto.user.UserDto;
import com.arjuncodes.studentsystem.dto.user.UserResponseDto;
import com.arjuncodes.studentsystem.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public User toEntity(UserDto dto) {
        User entity = new User();

        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setAddress(dto.getAddress());
        entity.setRole(dto.getRole());
        return entity;
    }

    public UserResponseDto toDto(User entity) {
        UserResponseDto dto = new UserResponseDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setAddress(entity.getAddress());
        dto.setPhone(entity.getPhone());
        dto.setRole(entity.getRole());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public List<UserResponseDto> toDtoList(List<User> entities) {
        if (entities == null || entities.isEmpty()) {
            return new ArrayList<>();
        }

        return entities.stream()
            .map(user -> this.toDto(user))
            .collect(Collectors.toList());
    }

    public void updateEntityFromDto(User entity, UpdateUserDto dto) {
        if(entity == null || dto == null) {
            return;
        }

        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setAddress(dto.getAddress());
        entity.setRole(dto.getRole());
    }
}
