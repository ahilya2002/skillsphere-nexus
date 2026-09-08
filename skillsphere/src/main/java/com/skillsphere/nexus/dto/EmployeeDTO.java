package com.skillsphere.nexus.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private UUID employeeId;
    private String name;
    private String designation;
    private String department;
    private String email;
    private String role;      // sent/received as String, converted to Role enum in service
    private boolean isActive;
}