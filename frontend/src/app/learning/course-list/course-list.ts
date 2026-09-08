import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Learning } from '../learning';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {
  courses: any[] = [];
  empId = 'e9d0e83b-8722-4cd1-a845-cd5af5f973a0'; // your test employee from M1

  constructor(private learningService: Learning) {}

  ngOnInit(): void {
    this.learningService.getCourses().subscribe((data: any) => {
      this.courses = data;
    });
  }

  enroll(courseId: string) {
    this.learningService.enroll(this.empId, courseId).subscribe({
      next: () => alert('Enrolled successfully!'),
      error: (err) => alert('Enrollment failed: ' + err.message)
    });
  }
}