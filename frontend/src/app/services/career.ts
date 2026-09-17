import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class Career {
private baseUrl = 'http://localhost:8080/career/api/career';  
  constructor(private http: HttpClient) {}

  getCareerPlans() {
    return this.http.get<any[]>(`${this.baseUrl}/plans`);
  }

  createCareerPlan(data: any) {
    return this.http.post(`${this.baseUrl}/plans`, data);
  }

  updateCareerPlan(id: string, data: any) {
    return this.http.put(`${this.baseUrl}/plans/${id}`, data);
  }

  getJobs() {
    return this.http.get<any[]>(`${this.baseUrl}/jobs/active`);
  }

  createJob(data: any) {
    return this.http.post(`${this.baseUrl}/jobs`, data);
  }

  getAnalytics() {
    return this.http.get<any>(`${this.baseUrl}/analytics`);
  }
}