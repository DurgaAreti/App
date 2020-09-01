package com.application.in.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.in.model.Employee;

public interface EmployeeRepository   extends  JpaRepository<Employee, Long>{
	
	

	Optional<Employee> findByUserName(String userName);

}
