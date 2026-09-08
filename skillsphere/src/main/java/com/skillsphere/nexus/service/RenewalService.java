package com.skillsphere.nexus.service;


import com.skillsphere.nexus.entity.Certification;
import com.skillsphere.nexus.entity.CertificationRenewal;
import com.skillsphere.nexus.repository.CertificationRenewalRepository;
import com.skillsphere.nexus.repository.CertificationRepository;
import com.skillsphere.nexus.config.KafkaCertificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class RenewalService {

    @Autowired
    private CertificationRepository certificationRepository;

    @Autowired
    private CertificationRenewalRepository renewalRepository;

    @Autowired
    private CertificationAuditService auditService;

    @Autowired
    private KafkaCertificationProducer kafkaProducer;

    public CertificationRenewal requestRenewal(UUID certificationId, String requestedBy) {
        Certification cert = certificationRepository.findById(certificationId)
                .orElseThrow(() -> new RuntimeException("Certification not found"));

        CertificationRenewal renewal = CertificationRenewal.builder()
                .certification(cert)
                .oldExpiry(cert.getExpiryDate())
                .status(CertificationRenewal.RenewalStatus.REQUESTED)
                .requestedBy(requestedBy)
                .requestedAt(LocalDateTime.now())
                .build();

        CertificationRenewal saved = renewalRepository.save(renewal);

        auditService.log(cert.getCertificationId(), cert.getEmployee().getEmployeeId(), "RENEWAL_REQUESTED", requestedBy);

        kafkaProducer.sendRenewalEvent(
                "Certification renewal requested: " + cert.getCertificationName()
                        + " for employee " + cert.getEmployee().getName()
        );
        return saved;
    }

    public CertificationRenewal approveRenewal(UUID renewalId, LocalDate newExpiry, String approvedBy) {
        CertificationRenewal renewal = renewalRepository.findById(renewalId)
                .orElseThrow(() -> new RuntimeException("Renewal not found"));

        Certification cert = renewal.getCertification();
        cert.setExpiryDate(newExpiry);
        cert.setStatus(Certification.Status.VALID);
        certificationRepository.save(cert);

        renewal.setNewExpiry(newExpiry);
        renewal.setApprovedBy(approvedBy);
        renewal.setApprovedAt(LocalDateTime.now());
        renewal.setStatus(CertificationRenewal.RenewalStatus.APPROVED);

        CertificationRenewal saved = renewalRepository.save(renewal);

        auditService.log(cert.getCertificationId(), cert.getEmployee().getEmployeeId(), "RENEWED", approvedBy);

        return saved;
    }
}