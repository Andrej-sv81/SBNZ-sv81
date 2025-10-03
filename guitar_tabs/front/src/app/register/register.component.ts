import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

constructor(private router: Router) {}

email: string = '';
password: string = '';
level: string = "ANY";
genre: string = "ANY";
goal: string = "ANY";

onRegister() {
  //call service
  this.router.navigate(['/login']);
}

switchToLogin() {
  this.router.navigate(['/login']);
}

}
