import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { DashadminComponent } from './dashadmin/dashadmin.component';
import { PackadminComponent } from './packadmin/packadmin.component';
import { PackeditComponent } from './packedit/packedit.component';
import { PackcreateComponent } from './packcreate/packcreate.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    DashadminComponent,
    PackadminComponent,
    PackeditComponent,
    PackcreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
