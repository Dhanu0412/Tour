import { Component, Input, OnInit } from '@angular/core';
import { EmailValidator } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerserviceService } from '../customerservice.service';


@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  @Input()
  customerDetails = { email: '', password: '' };

  customer: any = [];
  message: any = '';

  constructor(
    public router: Router,
    public aroute: ActivatedRoute,
    public restApi: CustomerserviceService
  ) { }

  ngOnInit(): void {
  }

  loginCustomer() {
    this.restApi.getCustomer(this.customerDetails.email).subscribe((data: any) => (this.customer = data));
    if (this.customer != null) {
      if (this.customerDetails.password == this.customer.password) {
        this.message = "Correct Password";
      }
      else {
        this.message = "Please check your password";
      }
    }
    else {
      this.message = "You are not a registered user !!! Please Register"
    }
  }

}
