package com.skillsphere.nexus.repository;

import com.skillsphere.nexus.entity.LearningPath;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface LearningPathRepository extends JpaRepository<LearningPath, UUID> {
}