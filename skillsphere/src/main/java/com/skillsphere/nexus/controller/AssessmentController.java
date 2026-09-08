package com.skillsphere.nexus.controller;

import com.skillsphere.nexus.entity.Assessment;
import com.skillsphere.nexus.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @GetMapping
    public List<Assessment> getAllAssessments() {
        return assessmentService.getAllAssessments();
    }

    @GetMapping("/{id}")
    public Assessment getAssessmentById(@PathVariable UUID id) {
        return assessmentService.getAssessmentById(id);
    }

    @PostMapping
    public Assessment createAssessment(@RequestBody Assessment assessment) {
        return assessmentService.createAssessment(assessment);
    }
}