import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PackadminComponent } from './packadmin/packadmin.component';

const routes: Routes = [
  { path: 'packadmin', component: PackadminComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
