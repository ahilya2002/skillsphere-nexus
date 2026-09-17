import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Learning } from '../../learning/learning';
import { Career } from '../../services/career';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css'
})
export class DashboardComponent implements OnInit {
  courseCount: number | null = null;
  jobCount: number | null = null;
  careerPlanCount: number | null = null;

  constructor(
    private learningService: Learning,
    private careerService: Career
  ) {}

  ngOnInit(): void {
    this.learningService.getCourses().subscribe({
      next: (data: any) => this.courseCount = data.length,
      error: () => this.courseCount = 0
    });

    this.careerService.getJobs().subscribe({
      next: (data: any) => this.jobCount = data.length,
      error: () => this.jobCount = 0
    });

    this.careerService.getCareerPlans().subscribe({
      next: (data: any) => this.careerPlanCount = data.length,
      error: () => this.careerPlanCount = 0
    });
  }
}