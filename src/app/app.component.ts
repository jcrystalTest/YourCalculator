import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  
  username: string;
  register: any;
  enter:boolean = false;

  msgGreeting: string;
  operators = [];
  value1:number;
  value2:number;
  operator:string;
  result: number;
  constructor(public http: HttpClient) { }
  ngOnInit(): void {
    
  }

  onEnter(){
    console.log("Hello world");
    this.enter = true;
  }

  calculate(){
    console.log("Hello world");
    this.result = 0;
  }
  
}
