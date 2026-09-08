package com.skillsphere.nexus.service;

import com.skillsphere.nexus.dto.EnrollmentDTO;
import com.skillsphere.nexus.entity.Course;
import com.skillsphere.nexus.entity.Enrollment;
import com.skillsphere.nexus.repository.CourseRepository;
import com.skillsphere.nexus.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentDTO enroll(UUID empId, UUID courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = Enrollment.builder()
                .empId(empId)
                .course(course)
                .enrolledAt(LocalDateTime.now())
                .progress(0)
                .completed(false)
                .score(0.0f)
                .build();

        return toDTO(enrollmentRepository.save(enrollment));
    }

    public List<EnrollmentDTO> getEmployeeEnrollments(UUID empId) {
        return enrollmentRepository.findByEmpId(empId)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    private EnrollmentDTO toDTO(Enrollment e) {
        return EnrollmentDTO.builder()
                .enrollmentId(e.getEnrollmentId())
                .empId(e.getEmpId())
                .courseId(e.getCourse().getCourseId())
                .enrolledAt(e.getEnrolledAt())
                .progress(e.getProgress())
                .completed(e.getCompleted())
                .score(e.getScore())
                .completedAt(e.getCompletedAt())
                .build();
    }
}