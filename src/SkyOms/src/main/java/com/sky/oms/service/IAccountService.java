package com.sky.oms.service;

import com.sky.oms.dto.request.RegisterRequest;
import com.sky.oms.dto.response.BaseResponse;
import com.sky.oms.entity.CommonUser;

public interface IAccountService {

	BaseResponse<CommonUser> login(String userName, String password);

	BaseResponse register(RegisterRequest registerRequest);

}
