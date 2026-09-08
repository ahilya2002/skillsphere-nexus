package com.skillsphere.nexus.service;

import com.skillsphere.nexus.entity.CertificationAudit;
import com.skillsphere.nexus.repository.CertificationAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CertificationAuditService {

    @Autowired
    private CertificationAuditRepository repository;

    public void log(UUID certificationId, UUID employeeId, String action, String performedBy) {
        CertificationAudit audit = CertificationAudit.builder()
                .certificationId(certificationId)
                .employeeId(employeeId)
                .action(action)
                .performedBy(performedBy)
                .performedAt(LocalDateTime.now())
                .build();
        repository.save(audit);
    }

    public List<CertificationAudit> getAudit(UUID certificationId) {
        return repository.findByCertificationIdOrderByPerformedAtDesc(certificationId);
    }
}