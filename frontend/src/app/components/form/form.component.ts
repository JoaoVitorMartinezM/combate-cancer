import { Component } from '@angular/core';
import {FormBuilder, FormGroup, NonNullableFormBuilder, Validators} from "@angular/forms";
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

  constructor(private fb: NonNullableFormBuilder, private formService: FormService) {

    this.formGroup = fb.group({
      fullName: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      birthday: ['', [Validators.required]],
      sex: ['', [Validators.required]],
      diseases: [[''], [Validators.required]],
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
    let result : number = 0
    switch (this.screenShowed) {
      case 1:
        result = this.fieldsValidation();
        result === 2 ? this.screenShowed++ : this.screenShowed;
        break;
      case 2:
        result = this.fieldsValidation();
        result === 0 ? this.screenShowed++ : this.screenShowed;
        break;
      default:
        this.screenShowed++;
        break;
    }
  }

  fieldsValidation() : number {
    let errorsCounter = 0;
    Object.keys(this.formGroup.controls).forEach(key => {
      this.formGroup.controls[key].errors ? errorsCounter++ : errorsCounter
      this.formGroup.get(key)?.markAsTouched()
    });
    return errorsCounter;
  }

}
