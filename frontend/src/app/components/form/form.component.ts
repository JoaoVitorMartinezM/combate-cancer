import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {FormService} from "../../service/form.service";

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent {

  formGroup: FormGroup;
  screenShowed: number = 1;

  fullName?: string;
  email?: string;
  birthday?: Date;
  sex?: string;
  diseases?: string[]
  smoke?: boolean;
  quitSmoke?: boolean;
  drink?: boolean;
  haveCancer?: boolean;
  cancerHistory?: boolean;
  wentDentist?: boolean;
  sunscreen?: boolean;
  consumeMate?: boolean;
  sunstroke?: boolean;
  skinLesion?: boolean;

  constructor(private fb: FormBuilder, private formService: FormService) {

    this.formGroup = fb.group({
      fullName: [null, [Validators.required]],
      email: [null, [Validators.required, Validators.email]],
      birthday: [null, [Validators.required]],
      sex: [null, [Validators.required]],
      diseases: [null, [Validators.required]],
      smoke: [false, [Validators.required]],
      quitSmoke: [false, [Validators.required]],
      drink: [false, [Validators.required]],
      haveCancer: [false, [Validators.required]],
      cancerHistory: [false, [Validators.required]],
      wentDentist: [false, [Validators.required]],
      sunscreen: [false, [Validators.required]],
      consumeMate: [false, [Validators.required]],
      sunstroke: [false, [Validators.required]],
      skinLesion: [false, [Validators.required]],
    })
  }

  submit() {
    if(this.formGroup.valid) {

      this.formService.submit(this.formGroup.getRawValue())
        .subscribe({
          next: (value: Boolean) => {
            alert('deu boa')
          },
          error: (err) => {
            alert('deu ruim')
          }
        });
    } else {
      alert('n fode');
    }
  }

  next() {
    switch (this.screenShowed) {
      case 1:
        this.validateScreen1();
        break;
      case 2:
        this.validateScreen2();
        break;

    }


  }

  validateScreen1() {
    if(this.screenShowed == 1) {
      this.fullName = this.formGroup.get('fullName')?.value;
      this.email = this.formGroup.get('email')?.value;

      if(!this.fullName) {
        this.formGroup.get('fullName')?.markAsTouched()
      }
      if(!this.email) {
        this.formGroup.get('email')?.markAsTouched()
      }
      if(this.fullName && this.email && this.formGroup.get('email')?.valid) {
        this.screenShowed++;
      }

      console.log(this.formGroup.get('fullName')?.value);
      console.log(this.formGroup.get('email')?.value);
    }
  }

  validateScreen2() {
    this.birthday = this.formGroup.get('birthday')?.value;
    this.sex = this.formGroup.get('sex')?.value;

    if(!this.birthday) {
      this.formGroup.get('birthday')?.markAsTouched()
    }
    if(!this.sex) {
      this.formGroup.get('sex')?.markAsTouched()
    }
    if(this.birthday && this.sex) {
      this.screenShowed++;
    }

    console.log(this.formGroup.get('fullName')?.value);
    console.log(this.formGroup.get('email')?.value);
  }
}
