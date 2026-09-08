package com.skillsphere.nexus.repository;

import com.skillsphere.nexus.entity.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, UUID> {

    List<EmployeeSkill> findByEmployeeEmployeeId(UUID employeeId);
    // derived query: "get all skill records for this one employee"
}