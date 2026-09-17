import { Routes } from '@angular/router';
import { CourseList } from './learning/course-list/course-list';
import { CertificationList } from './certification/certification-list/certification-list';
import { ExpiringCertifications } from './certification/expiring-certifications/expiring-certifications';
import { CareerComponent } from './pages/career/career';
import { JobsComponent } from './pages/jobs/jobs';
import { AnalyticsComponent } from './pages/analytics/analytics';

export const routes: Routes = [
  { path: 'courses', component: CourseList },
  { path: 'certifications', component: CertificationList },
  { path: 'certifications/expiring', component: ExpiringCertifications },
  { path: 'career', component: CareerComponent },
  { path: 'jobs', component: JobsComponent },
  { path: 'analytics', component: AnalyticsComponent },
  { path: '', redirectTo: 'courses', pathMatch: 'full' }
];