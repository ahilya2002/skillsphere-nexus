package com.skillsphere.nexus.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "certification_renewal")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificationRenewal {

    @Id
    @GeneratedValue
    private UUID renewalId;

    @ManyToOne
    @JoinColumn(name = "certification_id", nullable = false)
    private Certification certification;

    private LocalDate oldExpiry;
    private LocalDate newExpiry;

    @Enumerated(EnumType.STRING)
    private RenewalStatus status;

    private String requestedBy;
    private String approvedBy;

    private LocalDateTime requestedAt;
    private LocalDateTime approvedAt;

    public enum RenewalStatus {
        REQUESTED, APPROVED, REJECTED
    }
}