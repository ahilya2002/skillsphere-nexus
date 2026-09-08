package com.skillsphere.nexus.controller;

import com.skillsphere.nexus.entity.EmployeeSkill;
import com.skillsphere.nexus.service.EmployeeSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employee-skills")
public class EmployeeSkillController {

    @Autowired
    private EmployeeSkillService employeeSkillService;

    @GetMapping
    public List<EmployeeSkill> getAllEmployeeSkills() {
        return employeeSkillService.getAllEmployeeSkills();
    }

    @GetMapping("/{id}")
    public EmployeeSkill getEmployeeSkillById(@PathVariable UUID id) {
        return employeeSkillService.getEmployeeSkillById(id);
    }

    @GetMapping("/by-employee/{employeeId}")
    public List<EmployeeSkill> getSkillsForEmployee(@PathVariable UUID employeeId) {
        return employeeSkillService.getSkillsForEmployee(employeeId);
    }

    @PostMapping
    public EmployeeSkill createEmployeeSkill(@RequestBody EmployeeSkill employeeSkill) {
        return employeeSkillService.createEmployeeSkill(employeeSkill);
    }


}