package com.skillsphere.nexus.service;

import com.skillsphere.nexus.entity.Certification;
import com.skillsphere.nexus.repository.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class CertificationService {

    @Autowired
    private CertificationRepository certificationRepository;

    public List<Certification> getAllCertifications() {
        return certificationRepository.findAll();
    }

    public Certification getCertificationById(UUID id) {
        return certificationRepository.findById(id).orElse(null);
    }

    public Certification createCertification(Certification certification) {
        certification.setStatus(calculateStatus(certification.getExpiryDate()));
        return certificationRepository.save(certification);
    }

    public List<Certification> getByEmployee(UUID empId) {
        return certificationRepository.findByEmployeeEmployeeId(empId);
    }

    public List<Certification> getExpiring() {
        LocalDate today = LocalDate.now();
        LocalDate end = today.plusDays(30);
        List<Certification> expiring = certificationRepository.findByExpiryDateBetween(today, end);
        expiring.forEach(cert -> {
            cert.setStatus(Certification.Status.PENDING_RENEWAL);
            certificationRepository.save(cert);
        });
        return expiring;
    }

    public List<Certification> getExpired() {
        return certificationRepository.findByStatus(Certification.Status.EXPIRED);
    }

    private Certification.Status calculateStatus(LocalDate expiry) {
        LocalDate today = LocalDate.now();
        if (expiry == null || expiry.isBefore(today)) {
            return Certification.Status.EXPIRED;
        }
        if (!expiry.isAfter(today.plusDays(30))) {
            return Certification.Status.PENDING_RENEWAL;
        }
        return Certification.Status.VALID;
    }
}