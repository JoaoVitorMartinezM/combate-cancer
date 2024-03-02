import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {LoginResponse} from "../model/login.response.model";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Form} from "@angular/forms";

@Injectable({providedIn: 'root'})
export class FormService {

  constructor(private http: HttpClient) { }

  submit(form: Form): Observable<Boolean> {
    return this.http.post<Boolean>(environment.apiUrl + '/form', form);
  }

}
