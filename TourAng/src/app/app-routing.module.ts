import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { CustomerBookingsComponent } from './customer-bookings/customer-bookings.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PackadminComponent } from './packadmin/packadmin.component';
import { PackcreateComponent } from './packcreate/packcreate.component';
import { PackeditComponent } from './packedit/packedit.component';
import { SignUpComponent } from './sign-up/sign-up.component';

const routes: Routes = [
  // { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'navbar', component: NavbarComponent },
  { path: 'home', component: HomeComponent },
  { path: 'footer', component: FooterComponent },
  { path: 'sign-up', component: SignUpComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'customer-list', component: CustomerListComponent },
  { path: 'customer-bookings/:cid', component: CustomerBookingsComponent },
  { path: 'packadmin', component: PackadminComponent },
  { path: 'packcreate', component: PackcreateComponent },
  { path: 'packedit/:pid', component: PackeditComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }

export const routingComponents = [
  LoginComponent,
  SignUpComponent,
  NavbarComponent,
  FooterComponent,
  HomeComponent,
  AdminComponent,
  CustomerListComponent,
  CustomerBookingsComponent,
  PackadminComponent,
  PackcreateComponent,
  PackeditComponent];