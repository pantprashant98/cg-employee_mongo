import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable , throwError} from 'rxjs';
import { Employee } from '../model/employee.model';
import { catchError } from 'rxjs/operators';



@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = 'http://localhost:8080/springboot-crud-rest/api/v1/employees';

  constructor(private http: HttpClient) { }

  getEmployee(id: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createEmployee(employee: any): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}`, employee, { responseType: 'text' as 'json' }).pipe(
      catchError((error: HttpErrorResponse) => {
        const errorMsg = (error.error && error.error.message) || 'Employee already exists';
        return throwError(new Error(errorMsg));
      })
    );
  }


  updateEmployee(id: string, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteEmployee(id: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getEmployeesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
