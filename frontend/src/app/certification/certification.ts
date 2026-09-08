import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class Certification {
  private baseUrl = 'http://localhost:8082/api/certifications';

  constructor(private http: HttpClient) {}

  getAll() {
    return this.http.get(`${this.baseUrl}`);
  }

  getByEmployee(empId: string) {
    return this.http.get(`${this.baseUrl}/employee/${empId}`);
  }

  getExpiring() {
    return this.http.get(`${this.baseUrl}/expiring`);
  }

  getExpired() {
    return this.http.get(`${this.baseUrl}/expired`);
  }

  requestRenewal(certificationId: string, requestedBy: string) {
    return this.http.post(`${this.baseUrl}/renewals/${certificationId}`, null, {
      params: { requestedBy }
    });
  }

  approveRenewal(renewalId: string, newExpiry: string, approvedBy: string) {
    return this.http.put(`${this.baseUrl}/renewals/${renewalId}/approve`, null, {
      params: { newExpiry, approvedBy }
    });
  }

  getCompliance(empId: string) {
    return this.http.get(`${this.baseUrl}/compliance/${empId}`);
  }

  getReport() {
    return this.http.get(`${this.baseUrl}/report`);
  }
}