import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeBookComponent} from "./home-book/home-book.component";
import {LoginFormComponent} from "./login/login-form/login-form.component";
import {CartBookComponent} from "./cart-book/cart-book.component";
import {DetailsComponent} from "./details/details.component";
import {ListBookComponent} from "./list-book/list-book.component";


const routes: Routes = [{path:"" , component: HomeBookComponent},
  {path:"login",component:LoginFormComponent},
  {path:"cart",component:CartBookComponent},
  {path:"details", component:DetailsComponent},
  {path:"list",component:ListBookComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
