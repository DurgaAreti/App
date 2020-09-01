package com.application.in.service;

import java.util.List;

import com.application.in.Dto.EmployeeDto;
import com.application.in.Dto.LoginDto;
import com.application.in.model.Employee;

public interface EmployeeService {

	String registerEmp(EmployeeDto dto);

	String loginEmp(LoginDto dto);

	List<Employee> getAllUsers();

	EmployeeDto getUser(String userName);
	
	String deleteUser(String userName);
	
	String updateUser(String userName,EmployeeDto dto);

}
