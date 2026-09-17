package com.skillsphere.career_service.controller;

import com.skillsphere.career_service.dto.AnalyticsDTO;
import com.skillsphere.career_service.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/career/analytics")
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200")
public class AnalyticsController {

    private final AnalyticsService service;

    @GetMapping
    public AnalyticsDTO getAnalytics() {
        return service.getAnalytics();
    }
}