package com.skillsphere.nexus.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import com.skillsphere.nexus.entity.Certification;
import com.skillsphere.nexus.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/certifications")
public class CertificationController {

    @Autowired
    private CertificationService certificationService;

    @PreAuthorize("hasAnyRole('ADMIN','HR_MANAGER')")
    @GetMapping
    public List<Certification> getAllCertifications() {
        return certificationService.getAllCertifications();
    }

    @PreAuthorize("hasAnyRole('ADMIN','HR_MANAGER')")
    @GetMapping("/{id}")
    public Certification getCertificationById(@PathVariable UUID id) {
        return certificationService.getCertificationById(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN','HR_MANAGER')")
    @PostMapping
    public Certification createCertification(@RequestBody Certification certification) {
        return certificationService.createCertification(certification);
    }

    @PreAuthorize("hasAnyRole('ADMIN','HR_MANAGER','EMPLOYEE')")
    @GetMapping("/employee/{empId}")
    public List<Certification> getByEmployee(@PathVariable UUID empId) {
        return certificationService.getByEmployee(empId);
    }

    @PreAuthorize("hasAnyRole('ADMIN','HR_MANAGER')")
    @GetMapping("/expiring")
    public List<Certification> getExpiring() {
        return certificationService.getExpiring();
    }

    @PreAuthorize("hasAnyRole('ADMIN','HR_MANAGER')")
    @GetMapping("/expired")
    public List<Certification> getExpired() {
        return certificationService.getExpired();
    }
}