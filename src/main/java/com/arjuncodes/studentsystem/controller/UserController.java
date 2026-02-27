package com.arjuncodes.studentsystem.controller;

import com.arjuncodes.studentsystem.dto.base.Response;
import com.arjuncodes.studentsystem.dto.user.UpdateUserDto;
import com.arjuncodes.studentsystem.dto.user.UserDto;
import com.arjuncodes.studentsystem.dto.user.UserResponseDto;
import com.arjuncodes.studentsystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Response> createUser(@Valid @RequestBody UserDto payload) {
        userService.createUser(payload);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(Response.success("201", "success", "successfully created user."));
    }

    @GetMapping
    public ResponseEntity<Response> listUsers() {
        List<UserResponseDto> users = userService.listUsers();

        return ResponseEntity.status(HttpStatus.OK)
            .body(Response.success("200", "success", "successfully listed users.", users));
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<Response> getUserById(@PathVariable("user_id") Long userId) {
        UserResponseDto user = userService.getUserById(userId);

        return ResponseEntity.status(HttpStatus.OK)
            .body(Response.success("200", "success", "successfully get user.", user));

    }

    @PutMapping("/{user_id}")
    public ResponseEntity<Response> updateUser(@PathVariable("user_id") Long userId, @Valid @RequestBody UpdateUserDto payload) {
        userService.updateUser(userId, payload);

        return ResponseEntity.status(HttpStatus.OK)
            .body(Response.success("200", "success", "successfully updated user."));
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<Response> deleteUser(@PathVariable("user_id") Long userId) {
        userService.deleteUser(userId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .body(Response.success("200", "success", "successfully deleted user."));
    }
}
