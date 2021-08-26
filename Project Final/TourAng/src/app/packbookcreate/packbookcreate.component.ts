import { DatePipe } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Booking } from '../Booking';
import { CustomerserviceService } from '../customerservice.service';
import { PackagebookingserviceService } from '../packagebookingservice.service';
import { PackserviceService } from '../packservice.service';

@Component({
  selector: 'packbookcreate',
  templateUrl: './packbookcreate.component.html',
  styleUrls: ['./packbookcreate.component.css']
})
export class PackbookcreateComponent implements OnInit {

  public cid: any = this.aroute.snapshot.params['cid'];
  public pid: any = this.aroute.snapshot.params['pid'];
  public cusDetails: any = {};
  public packDetails: any = {};
  @Input()
  public booking: Booking = {
    noOfDays: 0,
    noOfPeope: 0,
    packageCost: 0,
    startDate: new Date(),
    endDate: new Date(),
    bookingDate: new Date(),
    packBookID: 0,
    pack: {
      packageID: 0,
      packageName: '',
      itenary: '',
      location: '',
      hotelName: '',
      hotelCostPerDay: 0,
      costPerDay: 0
    },
    customer: {
      customerID: 0,
      customerName: {
        fname: '',
        lname: ''
      },
      gender: '',
      password: '',
      email: '',
      dateOfBirth: new Date(),
      phone: "",
      address: {
        doorno: 0,
        street: '',
        city: '',
        pincode: 0
      }
    }
  };


  constructor(
    public aroute: ActivatedRoute,
    public custserv: CustomerserviceService,
    public packserv: PackserviceService,
    public pbookserv: PackagebookingserviceService,
    public router: Router
  ) { }

  ngOnInit(): any {
    this.packserv.getAPackage(this.pid).subscribe((data) => (this.booking.pack = data));
    this.custserv.getCustomerByID(this.cid).subscribe((data) => (this.booking.customer = data));
  }

  packBook() {
    Swal.fire({
      title: 'Please click Confirm to book your package!!',
      showCancelButton: true,
      confirmButtonText: `Confirm`,
      denyButtonText: `Cancel`,
    }).then((result: any) => {
      if (result.isConfirmed) {
        this.pbookserv.createPackBooking(this.booking).subscribe((data: {}) => { this.router.navigate(['/packlist-customer']) });
      } else if (result.isDenied) {
        this.router.navigate(['/packbookcreate', this.cid, this.pid]);
      }
    })

  }

}
