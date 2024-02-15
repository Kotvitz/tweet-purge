import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-login-callback',
  templateUrl: './login-callback.component.html',
  styleUrls: ['./login-callback.component.css'],
})
export class LoginCallbackComponent implements OnInit {
  
  constructor(private authService: AuthenticationService) {}

  ngOnInit(): void {
    this.authService.handleLoginCallback();
  }
}
