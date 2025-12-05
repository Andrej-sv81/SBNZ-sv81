import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-song-add',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './song-add.component.html',
  styleUrl: './song-add.component.css'
})
export class SongAddComponent {

  title: string = '';
  artist: string = '';
  content: string = '';
  level: string = '';
  genre: string = '';
  goal: string = '';

  constructor(private api: ApiService, private router: Router) {}

  onAddSong() {
    this.api.addSong(this.title, this.content, this.level, this.genre, this.goal, this.artist).subscribe({
      next: (response) => {
        alert('Song added!');
        this.title = '';
        this.artist = '';
        this.content = '';
        this.level = '';
        this.genre = '';
        this.goal = '';
      },
      error: () => alert('Failed to add song')
    });
  }

  onCancel() {
    this.router.navigate(['/user'])
  }
}
