package com.skillsphere.nexus.controller;

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

    @GetMapping
    public List<Certification> getAllCertifications() {
        return certificationService.getAllCertifications();
    }

    @GetMapping("/{id}")
    public Certification getCertificationById(@PathVariable UUID id) {
        return certificationService.getCertificationById(id);
    }

    @PostMapping
    public Certification createCertification(@RequestBody Certification certification) {
        return certificationService.createCertification(certification);
    }

    @GetMapping("/employee/{empId}")
    public List<Certification> getByEmployee(@PathVariable UUID empId) {
        return certificationService.getByEmployee(empId);
    }

    @GetMapping("/expiring")
    public List<Certification> getExpiring() {
        return certificationService.getExpiring();
    }

    @GetMapping("/expired")
    public List<Certification> getExpired() {
        return certificationService.getExpired();
    }
}