package com.arjuncodes.studentsystem.dto.user;

import com.arjuncodes.studentsystem.annotations.ValidEnum;
import com.arjuncodes.studentsystem.common.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateUserDto {
    @NotNull(message = "Name is required")
    @NotBlank(message = "Name must not be blank")
    private String name;

    @NotNull(message = "Email is required")
    @Email(message = "Email should be invalid")
    private String email;
    private String phone;
    private String address;

    @NotNull(message = "role is required")
    @ValidEnum(enumClass = Role.class, message = "Role must be in [USER, ADMIN]")
    private String role;
}
