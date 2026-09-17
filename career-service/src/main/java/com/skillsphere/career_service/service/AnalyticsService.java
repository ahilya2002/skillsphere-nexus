package com.skillsphere.career_service.service;

import com.skillsphere.career_service.dto.AnalyticsDTO;
import com.skillsphere.career_service.entity.CareerPlan;
import com.skillsphere.career_service.repository.CareerPlanRepository;
import com.skillsphere.career_service.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final CareerPlanRepository careerPlanRepository;
    private final JobRepository jobRepository;

    public AnalyticsDTO getAnalytics() {
        var plans = careerPlanRepository.findAll();

        double averageProgress = plans.stream()
                .filter(p -> p.getProgress() != null)
                .mapToInt(CareerPlan::getProgress)
                .average().orElse(0);

        return AnalyticsDTO.builder()
                .totalCareerPlans(plans.size())
                .activeCareerPlans(careerPlanRepository.countByStatus(CareerPlan.PlanStatus.ACTIVE))
                .completedPlans(careerPlanRepository.countByStatus(CareerPlan.PlanStatus.COMPLETED))
                .promotionEligible(careerPlanRepository.countByPromotionEligibleTrue())
                .averageProgress(averageProgress)
                .skillCoverage(calculateSkillCoverage(plans))
                .activeJobs(jobRepository.findByActiveTrue().size())
                .build();
    }

    private double calculateSkillCoverage(java.util.List<CareerPlan> plans) {
        if (plans.isEmpty()) return 0;
        long withoutGap = plans.stream()
                .filter(p -> p.getSkillGaps() == null || p.getSkillGaps().isBlank())
                .count();
        return (withoutGap * 100.0) / plans.size();
    }
}