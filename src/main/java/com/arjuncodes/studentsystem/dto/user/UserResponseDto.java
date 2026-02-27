package com.arjuncodes.studentsystem.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonPropertyOrder({"user_id", "name", "email","phone_number", "location", "role_user", "created_at", "updated_at"})
public class UserResponseDto {
    @JsonProperty("user_id")
    private Long id;
    private String name;
    private String email;

    @JsonProperty("phone_number")
    private String phone;

    @JsonProperty("location")
    private String address;

    @JsonProperty("role_user")
    private String role = "USER";

    @JsonProperty("created_at")
    @JsonFormat(pattern = "MMMM dd, yyyy")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    @JsonFormat(pattern = "MMMM dd, yyyy")
    private LocalDateTime updatedAt;
}
