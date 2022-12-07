import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  constructor(private httpClient: HttpClient) { }

  public login(loginRequest){
    return this.httpClient.post('http://localhost:8080/api/public/login', {
      username: loginRequest.username,
      password: loginRequest.password
    })
  }

}
