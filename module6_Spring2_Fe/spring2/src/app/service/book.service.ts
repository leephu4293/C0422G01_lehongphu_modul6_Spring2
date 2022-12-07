import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {TokenService} from "../login/service/token.service";
import {BookStore} from "../model/book-store";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BookService {
  token = '';
  httpOptions: any;
  constructor(private httpClient: HttpClient, private loginService: TokenService) {
    this.token = loginService.getJwt();
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.token
      })
    };
  }

  getListBook(): Observable<any> {
    return this.httpClient.get<BookStore[]>("http://localhost:8080/api/public/list", this.httpOptions)
  }

  getListSearch(name: string):Observable<any>{
    console.log(name)
    return this.httpClient.get<BookStore[]>(`http://localhost:8080/api/public/search?name=${name}`,this.httpOptions)
  }

}
