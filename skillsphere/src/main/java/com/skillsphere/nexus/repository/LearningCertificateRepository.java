package com.skillsphere.nexus.repository;

import com.skillsphere.nexus.entity.LearningCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface LearningCertificateRepository extends JpaRepository<LearningCertificate, UUID> {
}