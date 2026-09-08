package com.skillsphere.nexus.controller;

import com.skillsphere.nexus.entity.CompetencyFramework;
import com.skillsphere.nexus.service.CompetencyFrameworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/competency-frameworks")
public class CompetencyFrameworkController {

    @Autowired
    private CompetencyFrameworkService competencyFrameworkService;

    @GetMapping
    public List<CompetencyFramework> getAllFrameworks() {
        return competencyFrameworkService.getAllFrameworks();
    }

    @GetMapping("/{id}")
    public CompetencyFramework getFrameworkById(@PathVariable UUID id) {
        return competencyFrameworkService.getFrameworkById(id);
    }

    @PostMapping
    public CompetencyFramework createFramework(@RequestBody CompetencyFramework framework) {
        return competencyFrameworkService.createFramework(framework);
    }
}