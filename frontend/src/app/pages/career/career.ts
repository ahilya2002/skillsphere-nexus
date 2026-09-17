import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Career } from '../../services/career';

@Component({
  selector: 'app-career',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './career.html',
  styleUrl: './career.css'
})
export class CareerComponent implements OnInit {
  plans: any[] = [];

  constructor(private careerService: Career) {}

  ngOnInit(): void {
    this.careerService.getCareerPlans().subscribe(data => {
      this.plans = data;
    });
  }
}