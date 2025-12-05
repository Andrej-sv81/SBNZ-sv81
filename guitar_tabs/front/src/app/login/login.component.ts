import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../api.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  email: string = '';
  password: string = '';

  constructor(private router: Router, private api: ApiService) {}

  onLogin() {
    if(this.email && this.password) {
      this.api.login(this.email, this.password).subscribe({
        next: (response) => {
          console.log('Login successful', response);
          localStorage.setItem('userEmail', this.email);
          this.router.navigate(['/user']);
        },
        error: (error) => {
          console.error('Login failed', error);
          alert('Login failed. Please check your credentials and try again.');
        }
      });}
  }

  switchToRegister() {
    this.router.navigate(['/register']);
  }
}
