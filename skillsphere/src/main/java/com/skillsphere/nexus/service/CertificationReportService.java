package com.skillsphere.nexus.service;

import com.skillsphere.nexus.dto.CertificationReportDTO;
import com.skillsphere.nexus.entity.Certification;
import com.skillsphere.nexus.repository.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CertificationReportService {

    @Autowired
    private CertificationRepository certificationRepository;

    public CertificationReportDTO generate() {
        List<Certification> all = certificationRepository.findAll();

        long total = all.size();
        long active = all.stream().filter(c -> c.getStatus() == Certification.Status.VALID).count();
        long expired = all.stream().filter(c -> c.getStatus() == Certification.Status.EXPIRED).count();
        long pending = all.stream().filter(c -> c.getStatus() == Certification.Status.PENDING_RENEWAL).count();

        LocalDate today = LocalDate.now();
        LocalDate end = today.plusDays(30);
        long expiring = all.stream()
                .filter(c -> c.getExpiryDate() != null
                        && !c.getExpiryDate().isBefore(today)
                        && !c.getExpiryDate().isAfter(end))
                .count();

        double renewalRate = total == 0 ? 0 : ((double) active / total) * 100;

        return CertificationReportDTO.builder()
                .total(total)
                .active(active)
                .expired(expired)
                .pendingRenewal(pending)
                .expiringWithin30Days(expiring)
                .renewalRate(Math.round(renewalRate * 100.0) / 100.0)
                .build();
    }
}