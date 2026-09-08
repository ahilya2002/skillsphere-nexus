package com.skillsphere.nexus.service;

import com.skillsphere.nexus.entity.Skill;
import com.skillsphere.nexus.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Skill getSkillById(UUID id) {
        return skillRepository.findById(id).orElse(null);
    }

    public Skill createSkill(Skill skill) {
        return skillRepository.save(skill);
    }
}