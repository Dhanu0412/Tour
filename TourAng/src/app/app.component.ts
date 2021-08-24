import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { CustomerserviceService } from './customerservice.service';

@Component({
  selector: "app-root",
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  [x: string]: any;
  title = 'TourAng'
  response:any
constructor(http: HttpClientModule){

}

  ngOnInit(){
    let obs = this.http.get('https://api.github.com/users/bharathb99');
    obs.subscribe((response: any) => console.log('Got the response'));
  }
}
