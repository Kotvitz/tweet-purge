import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  constructor(private http: HttpClient, private router: Router) {}

  initTwitterAuth() {
    console.log(environment.backendUrl);
    return this.http.get(`${environment.backendUrl}/auth/twitter`).pipe(
      catchError((error) => {
        console.error('Error initiating Twitter authentication:', error);
        this.router.navigate(['/login']);
        return throwError(() => error);
      })
    );
  }

  handleLoginCallback() {
    return this.http
      .get(`${environment.backendUrl}/auth/twitter/callback`)
      .pipe(
        catchError((error) => {
          console.error('Error handling login callback:', error);
          this.router.navigate(['/login']);
          return throwError(() => error);
        })
      );
  }
}
