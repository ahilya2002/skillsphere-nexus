import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Career } from '../../services/career';

@Component({
  selector: 'app-analytics',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './analytics.html',
  styleUrl: './analytics.css'
})
export class AnalyticsComponent implements OnInit {
  analytics: any;

  constructor(private careerService: Career) {}

  ngOnInit(): void {
    this.careerService.getAnalytics().subscribe(data => {
      this.analytics = data;
    });
  }
}