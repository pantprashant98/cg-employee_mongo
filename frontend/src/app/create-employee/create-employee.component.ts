import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {
  employee: any = {};
  submitted = false;
  errorMessage = '';

  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit(): void { }

  newEmployee(): void {
    this.submitted = false;
    this.employee = {};
  }

  saveEmployee(): void {
    this.employeeService.createEmployee(this.employee).subscribe(
      () => {
        console.log('Employee created successfully');
        this.submitted = true;
        ; // Clear any existing error messages
        this.router.navigate(['/employees']);
      },
      (error: any) => {
        console.error('Error while creating employee:', error);
        this.errorMessage = error.message || 'Error occurred while creating employee';
      }
    );
  }

  onSubmit(employeeForm: NgForm): void {
    if (employeeForm.valid) {
      this.saveEmployee();
    }
  }
}
