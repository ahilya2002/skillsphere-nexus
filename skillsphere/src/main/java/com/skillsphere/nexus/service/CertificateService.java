package com.skillsphere.nexus.service;

import com.skillsphere.nexus.entity.Enrollment;
import com.skillsphere.nexus.entity.LearningCertificate;
import com.skillsphere.nexus.repository.EnrollmentRepository;
import com.skillsphere.nexus.repository.LearningCertificateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CertificateService {

    private final EnrollmentRepository enrollmentRepository;
    private final LearningCertificateRepository certificateRepository;

    public LearningCertificate generateCertificate(UUID enrollmentId) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));

        if (!Boolean.TRUE.equals(enrollment.getCompleted())) {
            throw new RuntimeException("Course is not completed");
        }

        LearningCertificate certificate = LearningCertificate.builder()
                .empId(enrollment.getEmpId())
                .courseId(enrollment.getCourse().getCourseId())
                .courseName(enrollment.getCourse().getTitle())
                .score(enrollment.getScore())
                .issuedDate(LocalDate.now())
                .certificateNumber("SS-" + UUID.randomUUID())
                .build();

        return certificateRepository.save(certificate);
    }
}