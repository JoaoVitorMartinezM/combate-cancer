import { Component } from '@angular/core';
import {FormBuilder, FormGroup, NonNullableFormBuilder, ValidationErrors, Validators} from "@angular/forms";
import {FormService} from "../../service/form.service";
import {retry} from "rxjs";
import {SmokeOption} from "../../model/smokeOption.model";
import {NgFor} from "@angular/common";
import {FieldModel} from "../../model/field.model";

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss'],
})
export class FormComponent {

  formGroup: FormGroup;
  screenShowed: number = 1;

  smokeOptions: Array<FieldModel> = [];
  drinkOptions: Array<FieldModel> = [];
  sunscreenOptions: Array<FieldModel> = [];
  sunstrokeOptions: Array<FieldModel> = [];
  cancerOptions: Array<FieldModel> = [];
  dentistOptions: Array<FieldModel> = [];

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

  protected result: any[] = [];

  constructor(private fb: NonNullableFormBuilder, private formService: FormService) {

    this.formService.getDrinkOptions().subscribe({
      next: (data) => {
        this.drinkOptions = data;
      }

    });

    this.formService.getSmokeOptions().subscribe({
      next: (data) => {
        this.smokeOptions = data;
      }

    });

    this.formService.getCancerOptions().subscribe({
      next: (data) => {
        this.cancerOptions = data;
      }

    });

    this.formService.getSunscreenOptions().subscribe({
      next: (data) => {
        this.sunscreenOptions = data;
      }

    });

    this.formService.getSunstrokeOptions().subscribe({
      next: (data) => {
        this.sunstrokeOptions = data;
      }

    });

    this.formService.getDentistOptions().subscribe({
      next: (data) => {
        this.dentistOptions = data;
      }

    });



    this.formGroup = fb.group({
      fullName: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      birthday: ['', [Validators.required]],
      sex: ['', [Validators.required]],
      diseases: [[''], [Validators.required]],
      smoke: [[''], [Validators.required]],
      skin: [[''], [Validators.required]],
      dentist: [[''], [Validators.required]],
      cancer: [[''], [Validators.required]],
      drink: [[''], [Validators.required]],
      sunscreen: [[''], [Validators.required]],
      // quitSmoke: [false, [Validators.required]],
      // haveCancer: [false, [Validators.required]],
      // cancerHistory: [false, [Validators.required]],
      // consumeMate: [false, [Validators.required]],
      // sunstroke: [false, [Validators.required]],
      // skinLesion: [false, [Validators.required]],
    })

    this.listenToAgeChange()
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
      alert('Exceção');
    }
  }

  listenToAgeChange(){
    this.formGroup.get("fullName")?.valueChanges.subscribe(fullName=>{
      if(fullName){
        this.formGroup.get("fullName")?.setErrors(null)  // <--- Set invalidNumber to true
      }
    })
  }


  next() {
    switch (this.screenShowed) {
      case 1:
        !this.fieldsValidation(['fullName', 'email', 'birthday', 'sex']) ? this.screenShowed++ : this.screenShowed;
        break;
      default:
        this.screenShowed++;
        break;
    }
  }

  fieldsValidation(fields : string[]) : boolean{
    this.result = []
    Object.keys(this.formGroup.controls).forEach(key => {
      const controlErrors: ValidationErrors | null | undefined = this.formGroup.get(key)?.errors;

      if (controlErrors && fields.indexOf(key) !== -1) {
        this.formGroup.get(key)?.markAsTouched()
        Object.keys(controlErrors).forEach(keyError => {
          this.result.push({
            'control': key,
            'error': keyError,
            'value': controlErrors[keyError]
          });
        });

      }
    });

    return this.result.length > 0;


  }

}
