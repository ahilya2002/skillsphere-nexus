package com.skillsphere.nexus.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "certification_audit")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificationAudit {

    @Id
    @GeneratedValue
    private UUID auditId;

    private UUID certificationId;
    private UUID employeeId;
    private String action;
    private String performedBy;
    private LocalDateTime performedAt;
}