import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PackserviceService } from '../packservice.service';

@Component({
  selector: 'packedit',
  templateUrl: './packedit.component.html',
  styleUrls: ['./packedit.component.css']
})
export class PackeditComponent implements OnInit {
  packageData : any ={};
  packageid = this.aroute.snapshot.params['packageid'];
  constructor( 
    public router: Router,
    public aroute: ActivatedRoute,
    public restApi: PackserviceService) { }

    ngOnInit(): void {
      this.restApi
        .getAPackage(this.packageid)
        .subscribe((data) => (this.packageData = data));
    }
  
    updateEmployee() {
      if (window.confirm('Are you sure , you want to update?')) {
        this.restApi.updatePackage(this.packageData).subscribe((data: {}) => {
          this.router.navigate(['/packlist']);
        });
      }

}
