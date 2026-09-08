package com.skillsphere.nexus.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificationDTO {

    private UUID certificationId;
    private UUID employeeId;
    private String certificationName;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private String status;
}