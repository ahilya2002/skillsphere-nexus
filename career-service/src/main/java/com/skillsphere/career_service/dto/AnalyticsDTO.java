package com.skillsphere.career_service.dto;


import lombok.*;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AnalyticsDTO {
    private long totalCareerPlans;
    private long activeCareerPlans;
    private long completedPlans;
    private long promotionEligible;
    private double averageProgress;
    private double skillCoverage;
    private long activeJobs;
}