import { Routes } from '@angular/router';
import { CourseList } from './learning/course-list/course-list';
import { CertificationList } from './certification/certification-list/certification-list';
import { ExpiringCertifications } from './certification/expiring-certifications/expiring-certifications';
import { CareerComponent } from './pages/career/career';
import { JobsComponent } from './pages/jobs/jobs';
import { AnalyticsComponent } from './pages/analytics/analytics';
import { DashboardComponent } from './pages/dashboard/dashboard';
import { SkillsComponent } from './pages/skills/skills';
import { EmployeesComponent } from './pages/employees/employees';

export const routes: Routes = [
  { path: 'dashboard', component: DashboardComponent },
  { path: 'courses', component: CourseList },
  { path: 'certifications', component: CertificationList },
  { path: 'certifications/expiring', component: ExpiringCertifications },
  { path: 'career', component: CareerComponent },
  { path: 'jobs', component: JobsComponent },
  { path: 'analytics', component: AnalyticsComponent },
  { path: 'skills', component: SkillsComponent },
  { path: 'employees', component: EmployeesComponent },
  { path: '', redirectTo: 'dashboard', pathMatch: 'full' }
];