import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../Customer';
import { CustomerserviceService } from '../customerservice.service';

@Component({
  selector: 'sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  @Input()
  customerDetails: any = {
    customerName: {
      fname: '',
      lname: ''
    },
    gender: '',
    password: '',
    email: '',
    dateOfBirth: new Date(),
    phone: '',
    address: {
      doorno: 0,
      street: '',
      city: '',
      pincode: 0
    }
  };

  constructor(public restApi: CustomerserviceService, public router: Router) { }

  ngOnInit(): void {
  }

  addCustomer() {
    this.restApi.createCustomer(this.customerDetails).subscribe((data: {}) => { this.router.navigate(['/login']) });
  }

}
