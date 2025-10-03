import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  constructor(private router: Router, private api: ApiService) {}

  email: string = '';
  password: string = '';
  level: string = "ANY";
  genre: string = "ANY";
  goal: string = "ANY";

  onRegister() {
    this.api.register(this.email, this.password, this.level, this.genre, this.goal).subscribe({
      next: (response) => {
        this.router.navigate(['/login']);
      },
      error: (error) => {
        alert('Registration failed');
      }
    });
  }

  switchToLogin() {
    this.router.navigate(['/login']);
  }
}
