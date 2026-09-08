package com.skillsphere.nexus.repository;

import com.skillsphere.nexus.entity.CertificationRenewal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface CertificationRenewalRepository extends JpaRepository<CertificationRenewal, UUID> {
    List<CertificationRenewal> findByCertificationCertificationId(UUID certificationId);
}