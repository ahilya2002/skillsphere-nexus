package com.skillsphere.nexus.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "certification")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Certification {

    @Id
    @GeneratedValue
    private UUID certificationId;

    @ManyToOne
    private Employee employee;

    private String certificationName;
    private String issuingOrganization;
    private String credentialId;

    private LocalDate issueDate;
    private LocalDate expiryDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        VALID, EXPIRED, PENDING_RENEWAL
    }
}