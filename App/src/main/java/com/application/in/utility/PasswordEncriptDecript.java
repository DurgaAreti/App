package com.application.in.utility;

import com.application.in.Dto.LoginDto;
import com.application.in.model.Employee;

public interface PasswordEncriptDecript {
	
	 String encryptPassword(String password);
	 boolean ispassword(LoginDto loginDto, Employee employee);

}
