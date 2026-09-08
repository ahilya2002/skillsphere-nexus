package com.skillsphere.nexus.repository;

import com.skillsphere.nexus.entity.CompetencyFramework;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CompetencyFrameworkRepository extends JpaRepository<CompetencyFramework, UUID> {

}