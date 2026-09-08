package com.skillsphere.nexus.controller;

import com.skillsphere.nexus.entity.CertificationAudit;
import com.skillsphere.nexus.service.CertificationAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/certifications")
public class CertificationAuditController {

    @Autowired
    private CertificationAuditService auditService;

    @GetMapping("/{certificationId}/audit")
    public List<CertificationAudit> getAudit(@PathVariable UUID certificationId) {
        return auditService.getAudit(certificationId);
    }
}