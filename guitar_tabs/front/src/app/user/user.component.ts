import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

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

  songsTitle = 'Liked Songs';
  songs = [
    { title: 'Song 1', genre: 'Rock', level: 'Intermediate' },
    { title: 'Song 2', genre: 'Pop', level: 'Beginner' },
    { title: 'Song 3', genre: 'Jazz', level: 'Advanced' },
    { title: 'Song 4', genre: 'Blues', level: 'Intermediate' },
    { title: 'Song 5', genre: 'Metal', level: 'Advanced' },
    { title: 'Song 6', genre: 'Classical', level: 'Beginner' },
    { title: 'Song 7', genre: 'Country', level: 'Intermediate' },
    { title: 'Song 8', genre: 'Reggae', level: 'Beginner' },
    { title: 'Song 9', genre: 'Funk', level: 'Advanced' },
    { title: 'Song 10', genre: 'Punk', level: 'Intermediate' },
    { title: 'Song 11', genre: 'Indie', level: 'Beginner' },
    { title: 'Song 12', genre: 'Alternative', level: 'Advanced' },
    { title: 'Song 13', genre: 'Electronic', level: 'Intermediate' },
    { title: 'Song 14', genre: 'Hip-Hop', level: 'Beginner' },
    { title: 'Song 15', genre: 'R&B', level: 'Advanced' },
    { title: 'Song 16', genre: 'Soul', level: 'Intermediate' },
    { title: 'Song 17', genre: 'Folk', level: 'Beginner' }, 
    { title: 'Song 18', genre: 'Disco', level: 'Advanced' },
    { title: 'Song 19', genre: 'Gospel', level: 'Intermediate' },
    { title: 'Song 20', genre: 'Ska', level: 'Beginner' },
    { title: 'Song 21', genre: 'Grunge', level: 'Advanced' },
    { title: 'Song 22', genre: 'Ambient', level: 'Intermediate' },
    { title: 'Song 23', genre: 'New Wave', level: 'Beginner' },
    { title: 'Song 24', genre: 'Synthpop', level: 'Advanced' },
    { title: 'Song 25', genre: 'Post-Punk', level: 'Intermediate' },
    { title: 'Song 26', genre: 'Shoegaze', level: 'Beginner' },
    { title: 'Song 27', genre: 'Dream Pop', level: 'Advanced' },
    // ...more songs
  ];

  showLiked() {
    this.songsTitle = 'Liked Songs';
    // this.songs = ... set liked songs
  }

  showRecommended() {
    this.songsTitle = 'Recommended Songs';
    // this.songs = ... set recommended songs
  }

  logOff() {
    throw new Error('Method not implemented.');
  }
}
