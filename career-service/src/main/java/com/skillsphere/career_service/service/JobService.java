package com.skillsphere.career_service.service;

import com.skillsphere.career_service.dto.JobDTO;
import com.skillsphere.career_service.entity.Job;
import com.skillsphere.career_service.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository repository;

    public JobDTO create(JobDTO dto) {
        Job job = Job.builder()
                .title(dto.getTitle()).department(dto.getDepartment())
                .requiredSkills(dto.getRequiredSkills())
                .minimumExperience(dto.getMinimumExperience())
                .active(true).build();
        return toDTO(repository.save(job));
    }

    public List<JobDTO> getAll() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public List<JobDTO> getActiveJobs() {
        return repository.findByActiveTrue().stream().map(this::toDTO).toList();
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    private JobDTO toDTO(Job j) {
        return JobDTO.builder()
                .jobId(j.getJobId()).title(j.getTitle())
                .department(j.getDepartment())
                .requiredSkills(j.getRequiredSkills())
                .minimumExperience(j.getMinimumExperience())
                .active(j.getActive()).build();
    }
}