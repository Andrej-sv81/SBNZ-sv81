import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-user',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {

  email = 'user@example.com';
  skill = 'Intermediate';
  genre = 'Rock';
  goal = 'Learn solos';
  songNumber = 12;
  chords = 'Am C G';
  songsTitle = 'All Songs';
  shownSongs: any[] = [];
  songs: any[] = [];
  likedSongs: any[] = [];
  likedIds: number[] = [];
  recomendedSongs: any[] = [];

  constructor(private router: Router, private api: ApiService) { }

  ngOnInit(){
    const userEmail = localStorage.getItem("userEmail");
    if(userEmail){
      this.email = userEmail;
      this.api.getUserData(userEmail).subscribe({
        next: (data) => {
          this.skill = data.level;
          this.genre = data.genre;
          this.goal = data.goal;
          this.songNumber = data.songNumber;
          this.chords = data.chords;
        },
        error: (err) => {
          console.error('Error fetching user data', err);
          alert('Error fetching user data');
        }
    });}

    this.api.getAllSongs(this.email).subscribe({
      next: (data) => {
        this.songs = data;
        this.shownSongs = this.songs;
        this.songNumber = this.songs.length;
      },
      error: (err) => {
        console.error('Error fetching songs', err);
        alert('Error fetching songs');
      }});

    this.api.getLikedSongIds(this.email).subscribe({
      next: (data) => {
        this.likedIds = data;
      },
      error: () => this.likedIds = []
    });
  }


  addSong() {
    this.router.navigate(['/song'])
  }

  showLiked() {
    this.songsTitle = 'Liked Songs';
    this.api.getLikedSongs(this.email).subscribe({
      next: (data) => this.shownSongs = data,
      error: () => this.shownSongs = []
    });
  }

  showRecommended() {
    this.songsTitle = 'Recommended Songs';
    this.api.getRecommendedSongs(this.email).subscribe({
      next: (data) => this.shownSongs = data,
      error: () => this.shownSongs = []
    });
  }

  showAll() {
    this.songsTitle = 'All Songs';
    this.shownSongs = this.songs;
  }

  logOff() {
    localStorage.removeItem("userEmail")
    this.router.navigate(['/login'])
  }

  editUser() {
    this.router.navigate(['/user-edit'], {
      state: {
        email: this.email,
        skill: this.skill,
        genre: this.genre,
        goal: this.goal,
        chords: this.chords
      }
    });
  }

  isLiked(songId: number): boolean {
    return this.likedIds.includes(songId);
  }

  toggleLike(songId: number) {
    this.api.toggleLikeSong(this.email, songId).subscribe({
      next: (updatedLikedSongs: number[]) => {
        this.likedIds = updatedLikedSongs;
      },
      error: () => alert('Failed to update liked songs')
    });

    }
}
