package com.skillsphere.nexus.service;

import com.skillsphere.nexus.dto.ComplianceDTO;
import com.skillsphere.nexus.entity.Certification;
import com.skillsphere.nexus.entity.Employee;
import com.skillsphere.nexus.repository.CertificationRepository;
import com.skillsphere.nexus.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ComplianceService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CertificationRepository certificationRepository;

    public ComplianceDTO getCompliance(UUID empId) {
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        List<Certification> certifications = certificationRepository.findByEmployeeEmployeeId(empId);

        long total = certifications.size();
        long expired = certifications.stream()
                .filter(c -> c.getStatus() == Certification.Status.EXPIRED)
                .count();
        long valid = certifications.stream()
                .filter(c -> c.getStatus() == Certification.Status.VALID)
                .count();

        return ComplianceDTO.builder()
                .employeeName(employee.getName())
                .totalCertifications(total)
                .validCertifications(valid)
                .expiredCertifications(expired)
                .compliant(total > 0 && expired == 0)
                .build();
    }
}