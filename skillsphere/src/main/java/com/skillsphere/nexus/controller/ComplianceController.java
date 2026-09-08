package com.skillsphere.nexus.controller;

import com.skillsphere.nexus.dto.ComplianceDTO;
import com.skillsphere.nexus.service.ComplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/certifications/compliance")
public class ComplianceController {

    @Autowired
    private ComplianceService complianceService;

    @GetMapping("/{empId}")
    public ComplianceDTO getCompliance(@PathVariable UUID empId) {
        return complianceService.getCompliance(empId);
    }
}