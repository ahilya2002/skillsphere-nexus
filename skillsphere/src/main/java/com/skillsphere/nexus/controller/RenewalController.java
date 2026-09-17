package com.skillsphere.nexus.controller;

import com.skillsphere.nexus.entity.CertificationRenewal;
import com.skillsphere.nexus.service.RenewalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/api/certifications/renewals")
public class RenewalController {

    @Autowired
    private RenewalService renewalService;

    @PostMapping("/{certificationId}")
    public CertificationRenewal request(@PathVariable UUID certificationId, @RequestParam String requestedBy) {
        return renewalService.requestRenewal(certificationId, requestedBy);
    }

    @PutMapping("/{renewalId}/approve")
    @PreAuthorize("hasAnyRole('ADMIN','HR_MANAGER')")
    public CertificationRenewal approve(@PathVariable UUID renewalId, @RequestParam LocalDate newExpiry, @RequestParam String approvedBy) {
        return renewalService.approveRenewal(renewalId, newExpiry, approvedBy);
    }
}