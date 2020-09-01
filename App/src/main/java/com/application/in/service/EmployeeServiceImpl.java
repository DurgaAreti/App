package com.application.in.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.application.in.Dto.EmployeeDto;
import com.application.in.Dto.LoginDto;
import com.application.in.Repository.EmployeeRepository;
import com.application.in.exception.EmployeeException;
import com.application.in.model.Employee;
import com.application.in.utility.DataClass;
import com.application.in.utility.PasswordEncriptDecript;

@Service
@Component
@PropertySource("classpath:messege.properties")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private PasswordEncriptDecript decript;
	@Autowired
	private DataClass dateClass;
	@Autowired
	private Environment env;

	@Override
	@Transactional
	public String registerEmp(EmployeeDto dto) {

		boolean isUser = employeeRepository.findByUserName(dto.getUserName()).isPresent();

		if (isUser) {
			throw new EmployeeException(env.getProperty("emp.not.present"));
		} else {
			Employee user = modelMapper.map(dto, Employee.class);
			user.setPassword(decript.encryptPassword(dto.getPassword()));
			user.setCreatedDate(dateClass.todayDate());
			user.setUpdatedDate(dateClass.todayDate());
			System.out.println(user);
			employeeRepository.save(user);
			return env.getProperty("emp.reg.success") ;
		}

	}

	@Override
	@Transactional
	public String loginEmp(LoginDto dto) {
		Optional<Employee> optionalEmployee = employeeRepository.findByUserName(dto.getUserName());
		return optionalEmployee.
				filter(user -> {
			return user != null;}).
				filter(user -> {
			return decript.ispassword(dto, user);
		}).map(user -> {
			//List<Employee> empList = employeeRepository.findAll();
		//	System.out.println("EMPlist" + empList);
			employeeRepository.save(user);
			return env.getProperty("emp.login.success");
		}).orElseThrow(() -> new EmployeeException(env.getProperty("emp.login.fail")));
	}

	@Override
	@Transactional
	public List<Employee> getAllUsers() {
		List<Employee> empList = employeeRepository.findAll();
		System.out.println(empList);
		if(empList != null) {
			//empList.remove
			 return empList;
		}
		return  null;
	}

	@Override
	public EmployeeDto getUser(String userName) {
		Optional<Employee> optionalEmployee = employeeRepository.findByUserName(userName);
		return optionalEmployee.filter(user -> {
			return user != null;
		}).map(user -> {
			EmployeeDto employeeDto = convertModelToDTO(user);
			return employeeDto;
		}).orElseThrow(() -> new EmployeeException("Checke User  name"));
	}

	@Override
	public String deleteUser(String userName) {
		Optional<Employee> optionalEmployee = employeeRepository.findByUserName(userName);
		return optionalEmployee.filter(user -> {
			return user != null;
		}).map(user -> {
			employeeRepository.delete(user);
			return env.getProperty("emp.delete.success");

		}).orElseThrow(() -> new EmployeeException(env.getProperty("emp.delete.fail")));

	}

	@Override
	public String updateUser(String userName, EmployeeDto dto) {
		Optional<Employee> optionalEmployee = employeeRepository.findByUserName(userName);
		return optionalEmployee.filter(user -> {
			return user != null;
		}).map(user -> {
			user.setFirstName(dto.getFirstName());
			user.setLastName(dto.getLastName());
			user.setEmailId(dto.getEmailId());
			user.setUserName(dto.getUserName());
			user.setPassword(decript.encryptPassword(dto.getPassword()));
			user.setUpdatedDate(dateClass.todayDate());
			employeeRepository.save(user);
			return env.getProperty("emp.update.success");

		}).orElseThrow(() -> new EmployeeException(env.getProperty("emp.update.fail")));

	}



	private EmployeeDto convertModelToDTO(Employee emp) {
		EmployeeDto empDTO = new EmployeeDto();
		empDTO.setEmailId(emp.getEmailId());
		empDTO.setFirstName(emp.getFirstName());
		empDTO.setLastName(emp.getLastName());
		empDTO.setUserName(emp.getUserName());

		return empDTO;
	}
}
