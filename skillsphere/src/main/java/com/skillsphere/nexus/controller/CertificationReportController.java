package com.skillsphere.nexus.controller;

import com.skillsphere.nexus.dto.CertificationReportDTO;
import com.skillsphere.nexus.service.CertificationReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/certifications/report")
public class CertificationReportController {

    @Autowired
    private CertificationReportService reportService;

    @GetMapping
    public CertificationReportDTO report() {
        return reportService.generate();
    }
}

