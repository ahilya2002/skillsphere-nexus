import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Certification } from '../certification';

@Component({
  selector: 'app-expiring-certifications',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './expiring-certifications.html',
  styleUrl: './expiring-certifications.css'
})
export class ExpiringCertifications implements OnInit {
  certifications: any[] = [];

  constructor(private certificationService: Certification) {}

  ngOnInit(): void {
    this.certificationService.getExpiring().subscribe((data: any) => {
      this.certifications = data;
    });
  }
}