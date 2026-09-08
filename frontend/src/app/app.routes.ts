import { Routes } from '@angular/router';
import { CourseList } from './learning/course-list/course-list';
import { CertificationList } from './certification/certification-list/certification-list';
import { ExpiringCertifications } from './certification/expiring-certifications/expiring-certifications';

export const routes: Routes = [
  { path: 'courses', component: CourseList },
  { path: 'certifications', component: CertificationList },
  { path: 'certifications/expiring', component: ExpiringCertifications },
  { path: '', redirectTo: 'courses', pathMatch: 'full' }
];