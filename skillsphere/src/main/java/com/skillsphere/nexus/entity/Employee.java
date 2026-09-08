package com.skillsphere.nexus.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.UUID;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue
    private UUID employeeId;

    private String name;

    private String designation;

    private String department;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Boolean isActive = true;

    public enum Role {
        DEVELOPER, MANAGER, TECH_LEAD, HR, ADMIN, TRAINING_MANAGER
    }
}