import { Injectable } from "@angular/core";
import { OperationType } from "./operation-type.enum";
import { HttpClient } from "@angular/common/http";
import { Calculation } from "./calculation";
import { Observable } from "rxjs";
import { environment } from "./../environments/environment";

@Injectable({
  providedIn: "root",
})
export class CalculatorService {
  constructor(private http: HttpClient) {}

  calculate(calculations: Array<Calculation>): Observable<Array<Calculation>> {
    return this.http.post<Array<Calculation>>(
      `${environment.contextPath}/calculate`,
      calculations
    );
  }

  retrieveCalculations(): Observable<Array<Calculation>> {
    return this.http.get<Array<Calculation>>(
      `${environment.contextPath}/history`
    );
  }
}
