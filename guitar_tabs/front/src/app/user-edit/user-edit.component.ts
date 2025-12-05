import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Location } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-user-edit',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './user-edit.component.html',
  styleUrl: './user-edit.component.css'
})
export class UserEditComponent {
  email: string = '';
  skill: string = 'NA';
  genre: string = 'NA';
  goal: string = 'NA';
  chords: string = '';

  constructor(private router: Router, private location: Location, private api: ApiService) {
    const state = this.location.getState() as any;
    this.email = state.email || '';
    this.skill = state.skill || 'NA';
    this.genre = state.genre || 'NA';
    this.goal = state.goal || 'NA';
    this.chords = state.chords || '*';
  }

  onSave() {
    this.api.updateUser(this.email, this.skill, this.genre, this.goal, this.chords).subscribe({
      next: () => {
        alert('User info updated!');
        this.router.navigate(['/user']);
      },
      error: () => alert('Failed to update user info')
    });
  }

  cancel() {
    this.router.navigate(['/user']);
  }
}
