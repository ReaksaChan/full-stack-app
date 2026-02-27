package com.arjuncodes.studentsystem.dto.student;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@JsonPropertyOrder({"student_id","student_name","gender","date_of_birth", "address", "phone_number", "email", "created_at", "updated_at"})
public class StudentResponseDto {
    @JsonProperty("student_id")
    private Long id;

    @JsonProperty("student_name")
    private String name;
    private String address;

    @JsonProperty("date_of_birth")
    @JsonFormat(pattern = "MMMM dd, yyyy")
    private LocalDate dob;
    private String gender;

    @JsonProperty("phone_number")
    private String phone;
    private String email;

    @JsonProperty("created_at")
    @JsonFormat(pattern = "MMM dd, yyyy")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    @JsonFormat(pattern = "MMM dd, yyyy")
    private LocalDateTime updatedAt;

}
