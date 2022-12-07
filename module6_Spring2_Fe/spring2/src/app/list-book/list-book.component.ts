import { Component, OnInit } from '@angular/core';
import {BookService} from "../service/book.service";
import {BookStore} from "../model/book-store";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-list-book',
  templateUrl: './list-book.component.html',
  styleUrls: ['./list-book.component.css']
})
export class ListBookComponent implements OnInit {
  list: BookStore [];
  searchForm: FormGroup;
  constructor(private serviceBook: BookService,) {
    this.serviceBook.getListBook().subscribe(data=>{
      this.list = data;
      this.searchForm= new FormGroup({
            name: new FormControl(),
      })
    })
  }

  ngOnInit(): void {
  }

  search() {
   let name: string = this.searchForm.value.name
    this.serviceBook.getListSearch(name).subscribe(data=>{
      this.list = data;
    })
  }
}
