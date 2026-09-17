package com.skillsphere.nexus.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import com.skillsphere.nexus.dto.CourseDTO;
import com.skillsphere.nexus.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/learning/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseDTO getCourse(@PathVariable UUID id) {
        return courseService.getCourse(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','TRAINING_MANAGER')")
    public CourseDTO createCourse(@RequestBody CourseDTO dto) {
        return courseService.createCourse(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','TRAINING_MANAGER')")
    public void deleteCourse(@PathVariable UUID id) {
        courseService.deleteCourse(id);
    }
}