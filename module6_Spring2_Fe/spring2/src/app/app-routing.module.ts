import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeBookComponent} from "./home-book/home-book.component";


const routes: Routes = [{path:"" , component: HomeBookComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
