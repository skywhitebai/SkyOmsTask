package com.sky.oms.dto.request;

import lombok.Data;

@Data
public class RegisterRequest {

	String userName;
	String password;
	String confirmPassword;
	String mobile;
	String realName;
	Integer gender;
	String email;
}
