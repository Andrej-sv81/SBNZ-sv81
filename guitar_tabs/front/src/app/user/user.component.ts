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
  songs: any[] = [];


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
          this.chords = data.chords
        },
        error: (err) => {
          console.error('Error fetching user data', err);
          alert('Error fetching user data');
        }
    });}


    this.api.getAllSongs(this.email).subscribe({
      next: (data) => {
        this.songs = data;
        this.songNumber = this.songs.length;
      },
      error: (err) => {
        console.error('Error fetching songs', err);
        alert('Error fetching songs');
      }});
  }


  

  addSong() {
    this.router.navigate(['/song'])
  }

  showLiked() {
    this.songsTitle = 'Liked Songs';
    // this.songs = ... set liked songs
  }

  showRecommended() {
    this.songsTitle = 'Recommended Songs';
    // this.songs = ... set recommended songs
  }

  showAll() {
    this.songsTitle = 'All Songs';
    // this.songs = ... set all songs
  }

  logOff() {
    localStorage.removeItem("userEmail")
    this.router.navigate(['/login'])
  }


}
