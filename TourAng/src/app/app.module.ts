import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerserviceService } from './customerservice.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { PackagebookingserviceService } from './packagebookingservice.service';
import { PackserviceService } from './packservice.service';
import { DatepickerModule } from 'ng2-datepicker';

@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    DatepickerModule
  ],
  providers: [CustomerserviceService, PackagebookingserviceService, PackserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
