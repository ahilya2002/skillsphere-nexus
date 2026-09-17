package com.skillsphere.career_service.controller;

import com.skillsphere.career_service.dto.JobDTO;
import com.skillsphere.career_service.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/career/jobs")
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200")
public class JobController {

    private final JobService service;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','HR_MANAGER')")
    public JobDTO create(@RequestBody JobDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<JobDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/active")
    public List<JobDTO> getActive() {
        return service.getActiveJobs();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','HR_MANAGER')")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}