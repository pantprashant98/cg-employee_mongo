import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../model/employee.model';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {
  id: string;
  employee: Employee = new Employee();
  submitted = false;
  errorMessage = '';

  constructor(private route: ActivatedRoute, private router: Router, private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.employeeService.getEmployee(this.id)
      .subscribe(data => {
        console.log(data);
        this.employee = data;
      }, error => console.log(error));
  }

  updateEmployee(): void {
    this.employeeService.updateEmployee(this.id, this.employee)
      .subscribe(data => {
        console.log(data);
        this.submitted = true;
        this.gotoList();
      }, error => {
        console.error('User already exists:', error);
        this.errorMessage = error.error.message || 'User already exists';
      });
  }

  onSubmit(form: any): void {
    if (form.valid) {
      this.updateEmployee();
    }
  }

  gotoList(): void {
    this.router.navigate(['/employees']);
  }
}
