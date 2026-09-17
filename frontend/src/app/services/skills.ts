import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class Skills {
  private baseUrl = 'http://localhost:8080/nexus/api/skills';

  constructor(private http: HttpClient) {}

  getAllSkills() {
    return this.http.get<any[]>(`${this.baseUrl}`);
  }

  createSkill(data: any) {
    return this.http.post(`${this.baseUrl}`, data);
  }
}