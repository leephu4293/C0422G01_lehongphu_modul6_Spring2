import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() { }

  public saveLocalStorage(loginResponse) {
    this.clearStorage()
    localStorage.setItem('jwt', loginResponse.jwt);
    localStorage.setItem('roles', JSON.stringify(loginResponse.roles));
    localStorage.setItem('accountId', loginResponse.accountId);

  }

  public saveSessionStorage(loginResponse) {
    this.clearStorage()
    sessionStorage.setItem('jwt', loginResponse.jwt);
    sessionStorage.setItem('roles', JSON.stringify(loginResponse.roles));
    sessionStorage.setItem('username', loginResponse.username);
    sessionStorage.setItem('accountId', loginResponse.accountId);
  }

  public getJwt(): string {
    if (localStorage.getItem('jwt') != null) {
      return localStorage.getItem('jwt');
    } else {
      return sessionStorage.getItem('jwt');
    }
  }

  public getUsername(): string {
    if (localStorage.getItem('username') != null) {
      return localStorage.getItem('username');
    } else {
      return sessionStorage.getItem('username');
    }
  }

  public getAccountId(): string {
    if (localStorage.getItem('accountId') != null) {
      return localStorage.getItem('accountId');
    } else {
      return sessionStorage.getItem('accountId');
    }
  }


  public getRoles(): string {
    if (localStorage.getItem('roles') != null) {
      return localStorage.getItem('roles');
    } else {
      return sessionStorage.getItem('roles');
    }
  }



  public clearStorage(){
    localStorage.clear();
    sessionStorage.clear();
  }
}
