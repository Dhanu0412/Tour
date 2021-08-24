import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerserviceService } from './customerservice.service';

@Component({
  selector: "app-root",
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'TourAng';
  public cid: any = this.aroute.snapshot.params['id'];
  public user = false;
  constructor(public restApi: CustomerserviceService,
    public aroute: ActivatedRoute,
    public router: Router) { }
  ngOnInit(): void {
    if (this.cid) {
      this.user = true;
    }
    else {
      this.user = false;
    }
  }
}
