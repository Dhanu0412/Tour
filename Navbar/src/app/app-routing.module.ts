import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PackadminComponent } from './packadmin/packadmin.component';
import { PackcreateComponent } from './packcreate/packcreate.component';
import { PackeditComponent } from './packedit/packedit.component';

const routes: Routes = [
  { path: 'packadmin', component: PackadminComponent },
  { path: 'packcreate', component: PackcreateComponent },
  { path: 'packedit/:pid', component: PackeditComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
