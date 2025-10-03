import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  baseUrl = 'http://localhost:8080/api/rules';

  constructor(private http: HttpClient) { }

  login(email: string, password: string): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/login`, { email, password });
  }

  register(email: string, password: string, level: string, genre: string, goal: string): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/register`, { email, password, level, genre, goal });
  }
}
