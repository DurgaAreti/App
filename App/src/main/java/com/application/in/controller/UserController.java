package com.application.in.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.in.Dto.EmployeeDto;
import com.application.in.Dto.LoginDto;
import com.application.in.Response.Response;
import com.application.in.model.Employee;
import com.application.in.service.EmployeeService;
import com.application.in.service.EmployeeServiceImpl;

@Controller
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/signup")
	public ResponseEntity<Response> registerUser(@Valid @RequestBody EmployeeDto employeeDto) {
		String messege = service.registerEmp(employeeDto);
		Response response = new Response(HttpStatus.OK.value(), messege);
		System.out.println(employeeDto);
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

	@PostMapping("/login")
	public ResponseEntity<Response> loginUser(@RequestBody LoginDto loginDto) {
		String messege = service.loginEmp(loginDto);
		Response response= new Response(HttpStatus.OK.value(),messege);
		return new ResponseEntity<Response>(response,HttpStatus.OK);

	}

	@PutMapping("/updateUser/{userName}")
	public ResponseEntity<Response> updateUser(@PathVariable String userName, @RequestBody EmployeeDto employeeDto) {
		String messege = service.updateUser(userName, employeeDto);
		Response response = new Response(HttpStatus.OK.value(), messege);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/getAllUsers")
	public List<Employee> getAllUser() {
		List<Employee> employeeList = service.getAllUsers();

		return employeeList;

	}

	@GetMapping("/getUser/{userName}")
	public EmployeeDto getUser(@PathVariable String userName) {

		EmployeeDto dto = service.getUser(userName);

		return dto;

	}

	@DeleteMapping("/delete/{userName}")
	public ResponseEntity<Response> deleteUser(@PathVariable String userName) {

		String messege = service.deleteUser(userName);
		Response response = new Response(HttpStatus.OK.value(), messege);

		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

}
