package com.skillsphere.nexus.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentDTO {

    private UUID assessmentId;
    private UUID employeeId;
    private UUID skillId;
    private double score;
    private LocalDate assessmentDate;
    private boolean verified;
}