package com.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{

    boolean existsByEmployeeId(Long employeeId);


    // public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    //     boolean existsByEmployeeId(Long employeeId);

    
}
