package com.skillsphere.nexus.repository;

import com.skillsphere.nexus.entity.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface CertificationRepository extends JpaRepository<Certification, UUID> {
    List<Certification> findByEmployeeEmployeeId(UUID empId);
    List<Certification> findByStatus(Certification.Status status);
    List<Certification> findByExpiryDateBetween(LocalDate start, LocalDate end);
}