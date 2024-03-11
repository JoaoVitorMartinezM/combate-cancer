import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {LoginResponse} from "../model/login.response.model";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Form} from "@angular/forms";
import {SmokeOption} from "../model/smokeOption.model";
import {FieldModel} from "../model/field.model";

@Injectable({providedIn: 'root'})
export class FormService {

  constructor(private http: HttpClient) { }

  submit(form: Form): Observable<Boolean> {
    return this.http.post<Boolean>(environment.apiUrl + '/form', form);
  }

  getSmokeOptions(): Observable<Array<FieldModel>> {
    return this.http.get<Array<any>>(`${environment.apiUrl}/fields/Tabagismo`);
  }

  getDrinkOptions(): Observable<Array<FieldModel>> {
    return this.http.get<Array<any>>(`${environment.apiUrl}/fields/Alcolismo`);
  }

  getSunscreenOptions(): Observable<Array<FieldModel>> {
    return this.http.get<Array<any>>(`${environment.apiUrl}/fields/Protetor Solar`);
  }

  getSunstrokeOptions(): Observable<Array<FieldModel>> {
    return this.http.get<Array<any>>(`${environment.apiUrl}/fields/Pele`);
  }

  getCancerOptions(): Observable<Array<FieldModel>> {
    return this.http.get<Array<any>>(`${environment.apiUrl}/fields/Cancer`);
  }

  getDentistOptions(): Observable<Array<FieldModel>> {
    return this.http.get<Array<any>>(`${environment.apiUrl}/fields/Dentista`);
  }



}
