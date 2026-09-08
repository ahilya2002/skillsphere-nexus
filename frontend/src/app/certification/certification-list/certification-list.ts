import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Certification } from '../certification';

@Component({
  selector: 'app-certification-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './certification-list.html',
  styleUrl: './certification-list.css'
})
export class CertificationList implements OnInit {
  certifications: any[] = [];
  empId = 'e9d0e83b-8722-4cd1-a845-cd5af5f973a0'; // your test employee

  constructor(private certificationService: Certification) {}

  ngOnInit(): void {
    this.certificationService.getByEmployee(this.empId).subscribe((data: any) => {
      this.certifications = data;
    });
  }
}