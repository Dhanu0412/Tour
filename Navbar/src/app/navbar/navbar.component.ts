import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerserviceService } from '../customerservice.service';

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
  template: 'The href is: {{href}}'
})
export class NavbarComponent implements OnInit {

  public href: string = "";

  public user: any;
  public admin = false;
  public cid: any = this.aroute.snapshot.params['id'];

  constructor(public restApi: CustomerserviceService,
    public aroute: ActivatedRoute,
    public router: Router) { }

  ngOnInit(): void {
    this.href = this.router.url;
    if (this.cid) {
      this.user = true;
    }
    else if (this.href == '/admin') {
      this.admin = true;
    }
    else {
      this.user = false;
    }
  }

  logout() {
    this.user = false;
    this.admin = false;
  }

}
