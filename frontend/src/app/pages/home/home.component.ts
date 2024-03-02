import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  form!: FormGroup;
  @ViewChild('productbar') productSearchBar: any;

  constructor(private fb: FormBuilder) {
  }

  ngOnInit(): void {

  }

}
