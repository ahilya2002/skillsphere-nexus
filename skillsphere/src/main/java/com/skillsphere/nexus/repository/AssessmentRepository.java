package com.skillsphere.nexus.repository;

import com.skillsphere.nexus.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AssessmentRepository extends JpaRepository<Assessment, UUID> {

}