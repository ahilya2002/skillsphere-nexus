import { Injectable } from '@angular/core';
import Keycloak from 'keycloak-js';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class KeycloakAuthService {
  private kc = new Keycloak({
    url: environment.keycloak.url,
    realm: environment.keycloak.realm,
    clientId: environment.keycloak.clientId
  });

  async init(): Promise<boolean> {
    return await this.kc.init({
      onLoad: 'login-required',
      checkLoginIframe: false
    });
  }

  async updateToken(): Promise<boolean> {
    if (!this.kc.authenticated) return false;
    return await this.kc.updateToken(30);
  }

  getToken(): string | undefined {
    return this.kc.token;
  }

  getUsername(): string | undefined {
    return this.kc.tokenParsed?.['preferred_username'];
  }

  getRoles(): string[] {
    const roles = this.kc.tokenParsed?.['realm_access']?.['roles'];
    return Array.isArray(roles) ? roles : [];
  }

  hasRole(role: string): boolean {
    return this.getRoles().includes(role.toLowerCase());
  }

  isLoggedIn(): boolean {
    return !!this.kc.authenticated;
  }

  async logout(): Promise<void> {
    await this.kc.logout({ redirectUri: window.location.origin });
  }

  async loginAs(username: string): Promise<void> {
  await this.kc.login({ loginHint: username, prompt: 'login' });
}
}