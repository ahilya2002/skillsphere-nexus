import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Employees } from '../../services/employees';

@Component({
  selector: 'app-employees',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './employees.html',
  styleUrl: './employees.css'
})
export class EmployeesComponent implements OnInit {
  employees: any[] = [];

  constructor(private employeesService: Employees) {}

  ngOnInit(): void {
    this.employeesService.getAllEmployees().subscribe({
      next: (data: any) => this.employees = data,
      error: (err) => console.error('Failed to load employees', err)
    });
  }
}