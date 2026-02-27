package com.arjuncodes.studentsystem.dto.user;

import com.arjuncodes.studentsystem.annotations.ValidEnum;
import com.arjuncodes.studentsystem.common.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotNull(message = "username is required")
    @Size(min = 4, max = 50, message = "username must be between 4 and 50 character")
    private String name;

    @NotNull(message = "Message is required")
    @Size(min = 8, max = 20, message = "password must be between 8 and 20 characters")
    private String password;

    @NotNull(message = "Email is required")
    @Email(message = "Email should be invalid")
    private String email;
    private String phone;
    private String address;

    @ValidEnum(enumClass = Role.class, message = "Role must be in [USER, ADMIN]")
    private String role;
}
