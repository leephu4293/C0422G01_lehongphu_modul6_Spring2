import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, FormsModule} from "@angular/forms";
import {Subscription} from "rxjs";
import {LoginserviceService} from "../service/loginservice.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  loginForm : FormGroup;
  isLogin: boolean;
  subscription: Subscription;


  constructor(private loginService : LoginserviceService, private router: Router) { }

  ngOnInit(): void {
    this.loginForm= new FormGroup({
      username: new FormControl(),
      password: new FormControl(),
    })
  }



  login() {
    let loginRequest = this.loginForm.value;
    this.loginService.login(loginRequest).subscribe(loginResponse=>{
      console.log(loginResponse)
       this.router.navigateByUrl("");
    })

  }
}
