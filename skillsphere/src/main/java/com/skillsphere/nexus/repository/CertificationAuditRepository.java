package com.skillsphere.nexus.repository;

import com.skillsphere.nexus.entity.CertificationAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface CertificationAuditRepository extends JpaRepository<CertificationAudit, UUID> {
    List<CertificationAudit> findByCertificationIdOrderByPerformedAtDesc(UUID certificationId);
}