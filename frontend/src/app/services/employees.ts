import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class Employees {
  private baseUrl = 'http://localhost:8080/nexus/api/employees';

  constructor(private http: HttpClient) {}

  getAllEmployees() {
    return this.http.get<any[]>(`${this.baseUrl}`);
  }
}