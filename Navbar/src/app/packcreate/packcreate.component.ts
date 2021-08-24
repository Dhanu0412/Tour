import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PackserviceService } from '../packservice.service';

@Component({
  selector: 'packcreate',
  templateUrl: './packcreate.component.html',
  styleUrls: ['./packcreate.component.css']
})
export class PackcreateComponent implements OnInit {

  @Input()
  packageDetails = { packagename: '', location: '', hotel: '', hotelcostperday: 0  , costperday: 0 , packageimage: ''};

  constructor(public restApi: PackserviceService, public router: Router) { }

  ngOnInit(): void {
  }
  addPackage() {
    this.restApi.createPackage(this.packageDetails).subscribe((data: {}) => {
      this.router.navigate(['/packlist']);
    });
  }

}
