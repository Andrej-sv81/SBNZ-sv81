import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UserComponent } from './user/user.component';
import { SongAddComponent } from './song-add/song-add.component';

export const routes: Routes = [
    {path: 'login', component: LoginComponent},
    {path: 'register', component: RegisterComponent},
    {path: 'user', component: UserComponent},
    {path: 'song', component: SongAddComponent},
    {path: '', redirectTo: 'login', pathMatch: 'full'},
];
