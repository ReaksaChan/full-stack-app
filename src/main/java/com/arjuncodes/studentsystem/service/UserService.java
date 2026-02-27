package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.dto.user.UpdateUserDto;
import com.arjuncodes.studentsystem.dto.user.UserDto;
import com.arjuncodes.studentsystem.dto.user.UserResponseDto;
import com.arjuncodes.studentsystem.entity.User;
import com.arjuncodes.studentsystem.exception.model.DuplicateResourceException;
import com.arjuncodes.studentsystem.exception.model.ResourceNotFoundException;
import com.arjuncodes.studentsystem.mapper.UserMapper;
import com.arjuncodes.studentsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper mapper;

    public void createUser(UserDto payload) {
        // validate if username is existed
        if(userRepository.existsByName(payload.getName())) {
            throw new DuplicateResourceException("username is already taken");
        }

        // validate if email is existed
        if (userRepository.existsByEmail(payload.getEmail())) {
            throw new DuplicateResourceException("email is already taken");
        }

        User userEntity = mapper.toEntity(payload);
        userRepository.save(userEntity);
    }

    public List<UserResponseDto> listUsers() {
        List<User> users = userRepository.findAll();

        return mapper.toDtoList(users);
    }

    public UserResponseDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("user not found"));

        return mapper.toDto(user);
    }

    public void updateUser(Long userId, UpdateUserDto payload) {
        User existingUser = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("user not found"));

        mapper.updateEntityFromDto(existingUser, payload);

        userRepository.save(existingUser);
    }

    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("user not found");
        }

        userRepository.deleteById(userId);
    }

}
