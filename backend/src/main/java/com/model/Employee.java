package com.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "employee")
public class Employee {

    @Id
    private String id;
    
    private long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate dateofBirth;
    private int last4Ssn;
    private String emailId;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public LocalDate getDateofBirth() {
        return dateofBirth;
    }
    public void setDateofBirth(LocalDate dateofBirth) {
        this.dateofBirth = dateofBirth;
    }
    public int getLast4Ssn() {
        return last4Ssn;
    }
    public void setLast4Ssn(int last4Ssn) {
        this.last4Ssn = last4Ssn;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    // Getters and setters
}
