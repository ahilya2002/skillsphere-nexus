import { Component, signal } from '@angular/core';
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router';
import { KeycloakAuthService } from './auth/keycloak.service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RouterLink, RouterLinkActive],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');

  constructor(public auth: KeycloakAuthService) {}

  get isHrOrAdmin(): boolean {
    return this.auth.hasRole('hr_manager') || this.auth.hasRole('admin');
  }

  logout() {
    this.auth.logout();
  }

  switchRole(username: string) {
  this.auth.loginAs(username);
}
}