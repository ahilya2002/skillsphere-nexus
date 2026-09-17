package com.skillsphere.career_service.controller;

import com.skillsphere.career_service.dto.CareerPlanDTO;
import com.skillsphere.career_service.service.CareerPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/career/plans")
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200")
public class CareerPlanController {

    private final CareerPlanService service;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','HR_MANAGER')")
    public CareerPlanDTO create(@RequestBody CareerPlanDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<CareerPlanDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CareerPlanDTO getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping("/employee/{empId}")
    public List<CareerPlanDTO> getByEmployee(@PathVariable UUID empId) {
        return service.getByEmployee(empId);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','HR_MANAGER')")
    public CareerPlanDTO update(@PathVariable UUID id, @RequestBody CareerPlanDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','HR_MANAGER')")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}