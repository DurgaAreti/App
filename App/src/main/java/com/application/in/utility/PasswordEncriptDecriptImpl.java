package com.application.in.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.application.in.Dto.LoginDto;
import com.application.in.model.Employee;


@Component
public class PasswordEncriptDecriptImpl  implements PasswordEncriptDecript{

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String encryptPassword(String password) {
		return passwordEncoder.encode(password);

	}

	@Override
	public boolean ispassword(LoginDto loginDto,Employee user)

	{
		return passwordEncoder.matches(loginDto.getPassword(), user.getPassword());

	}
}
