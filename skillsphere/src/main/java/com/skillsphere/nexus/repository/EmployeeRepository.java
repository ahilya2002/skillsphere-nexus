package com.skillsphere.nexus.repository;

import com.skillsphere.nexus.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

}