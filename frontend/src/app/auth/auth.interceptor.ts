import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { from, switchMap } from 'rxjs';
import { KeycloakAuthService } from './keycloak.service';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const auth = inject(KeycloakAuthService);

  if (!req.url.startsWith('http://localhost:8080')) {
    return next(req);
  }

  return from(auth.updateToken()).pipe(
    switchMap(() => {
      const token = auth.getToken();
      if (!token) return next(req);

      return next(req.clone({
        setHeaders: { Authorization: `Bearer ${token}` }
      }));
    })
  );
};