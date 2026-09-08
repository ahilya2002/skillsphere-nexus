package com.skillsphere.nexus.controller;

import com.skillsphere.nexus.entity.LearningCertificate;
import com.skillsphere.nexus.service.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/learning/certificates")
@RequiredArgsConstructor
public class CertificateController {

    private final CertificateService certificateService;

    @PostMapping("/{enrollmentId}")
    public LearningCertificate generateCertificate(@PathVariable UUID enrollmentId) {
        return certificateService.generateCertificate(enrollmentId);
    }
}