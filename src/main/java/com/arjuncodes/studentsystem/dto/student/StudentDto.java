package com.arjuncodes.studentsystem.dto.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    @NotNull(message = "Student name is required")
    @NotBlank(message = "Student name must not be blank")
    private String name;

    @NotNull(message = "Address is required")
    @Size(max = 255, message = "Address must not exceed 255 characters")
    private String address;

    @NotNull(message = "Date of Birth is required")
    private LocalDate dob;

    @NotNull(message = "Gender is required")
    private String gender;

    @Size(max = 14, message = "phone number must not exceed 14 characters")
    private String phone;

    @Email(message = "Email should be valid")
    @Size(max = 50, message = "email must not exceed 50 characters")
    private String email;
}
