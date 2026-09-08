package com.skillsphere.nexus.service;

import com.skillsphere.nexus.entity.EmployeeSkill;
import com.skillsphere.nexus.repository.EmployeeSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeSkillService {

    @Autowired
    private EmployeeSkillRepository employeeSkillRepository;

    public List<EmployeeSkill> getAllEmployeeSkills() {
        return employeeSkillRepository.findAll();
    }

    public EmployeeSkill getEmployeeSkillById(UUID id) {
        return employeeSkillRepository.findById(id).orElse(null);
    }

    public List<EmployeeSkill> getSkillsForEmployee(UUID employeeId) {
        return employeeSkillRepository.findByEmployeeEmployeeId(employeeId);
    }

    public EmployeeSkill createEmployeeSkill(EmployeeSkill employeeSkill) {
        return employeeSkillRepository.save(employeeSkill);
    }
}