import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {environment} from "../../../environments/environment";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  form!: FormGroup;
  @ViewChild('productbar') productSearchBar: any;

  appearence: string = environment.appearance;

  constructor(private fb: FormBuilder) {
  }

  ngOnInit(): void {

  }

}
