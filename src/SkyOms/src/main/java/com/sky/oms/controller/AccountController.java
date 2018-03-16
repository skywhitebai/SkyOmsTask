package com.sky.oms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sky.oms.dto.request.RegisterRequest;
import com.sky.oms.dto.response.BaseResponse;
import com.sky.oms.entity.CommonUser;
import com.sky.oms.service.IAccountService;

@Controller
@RequestMapping("account")
public class AccountController extends SuperController{
	@Autowired
	IAccountService accountService;
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	@RequestMapping("/login")
	@ResponseBody
	public BaseResponse<CommonUser> login(String userName,String password) {
	    BaseResponse<CommonUser> loginResult= accountService.login(userName,password);
		return loginResult;
	}
	@RequestMapping("/register")
	@ResponseBody
	public BaseResponse register(RegisterRequest registerRequest) {
	    BaseResponse registerResult= accountService.register(registerRequest);
		return registerResult;
	}
}
