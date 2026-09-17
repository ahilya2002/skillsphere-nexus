import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Career } from '../../services/career';

@Component({
  selector: 'app-jobs',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './jobs.html',
  styleUrl: './jobs.css'
})
export class JobsComponent implements OnInit {
  jobs: any[] = [];

  constructor(private careerService: Career) {}

  ngOnInit(): void {
    this.careerService.getJobs().subscribe(data => {
      this.jobs = data;
    });
  }
}