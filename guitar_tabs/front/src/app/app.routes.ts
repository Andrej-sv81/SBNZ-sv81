import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UserComponent } from './user/user.component';
import { SongAddComponent } from './song-add/song-add.component';
import { UserEditComponent } from './user-edit/user-edit.component';

export const routes: Routes = [
    {path: 'login', component: LoginComponent},
    {path: 'register', component: RegisterComponent},
    {path: 'user', component: UserComponent},
    {path: 'song', component: SongAddComponent},
    {path: 'user-edit', component: UserEditComponent},
    {path: '', redirectTo: 'login', pathMatch: 'full'},
];
