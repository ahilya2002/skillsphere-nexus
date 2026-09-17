import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Skills } from '../../services/skills';

@Component({
  selector: 'app-skills',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './skills.html',
  styleUrl: './skills.css'
})
export class SkillsComponent implements OnInit {
  skills: any[] = [];

  constructor(private skillService: Skills) {}

  ngOnInit(): void {
    this.skillService.getAllSkills().subscribe({
      next: (data: any) => this.skills = data,
      error: (err) => console.error('Failed to load skills', err)
    });
  }
}