package com.sky.oms.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sky.oms.dao.CommonUserMapper;
import com.sky.oms.dto.request.RegisterRequest;
import com.sky.oms.dto.response.BaseResponse;
import com.sky.oms.entity.CommonUser;
import com.sky.oms.entity.CommonUserExample;
import com.sky.oms.service.IAccountService;

@Service
public class AccountService implements IAccountService {

	@Autowired
	CommonUserMapper commonUserMapper;

	public BaseResponse<CommonUser> login(String userName, String password) {
		StringBuilder sbErro = new StringBuilder();
		if (StringUtils.isEmpty(userName)) {
			sbErro.append("用户名不能为空,");
		}
		if (StringUtils.isEmpty(password)) {
			sbErro.append("密码不能为空,");
		}
		if (sbErro.length() > 0) {
			return BaseResponse.failMessage(sbErro.substring(0,
					sbErro.length() - 1));
		}
		CommonUserExample commonUserExample = new CommonUserExample();
		commonUserExample.createCriteria().andUserNameEqualTo(userName)
				.andPasswordEqualTo(password);
		List<CommonUser> commonUserList = commonUserMapper
				.selectByExample(commonUserExample);
		if (commonUserList.size() > 0) {
			return BaseResponse.successData(commonUserList.get(1));
		}
		return BaseResponse.failMessage("登陆失败，请重新登陆");
	}

	public BaseResponse register(RegisterRequest registerRequest) {
		StringBuilder sbErro = new StringBuilder();
		if (StringUtils.isEmpty(registerRequest.getUserName())) {
			sbErro.append("用户名不能为空,");
		}
		if (StringUtils.isEmpty(registerRequest.getPassword())) {
			sbErro.append("密码不能为空,");
		}
		if (StringUtils.isEmpty(registerRequest.getConfirmPassword())) {
			sbErro.append("确认密码不能为空,");
		}
		if (!StringUtils.isEmpty(registerRequest.getPassword())
				&& !StringUtils.isEmpty(registerRequest.getConfirmPassword())
				&&!registerRequest.getPassword().equals(registerRequest.getConfirmPassword())) {
			sbErro.append("密码和确认密码不一致,");
		}
		if (sbErro.length() > 0) {
			return BaseResponse.failMessage(sbErro.substring(0,
					sbErro.length() - 1));
		}
		CommonUser commonUser=new CommonUser();
		BeanUtils.copyProperties(registerRequest, commonUser);
		int result=commonUserMapper.insertSelective(commonUser);
		if(result>0){
			return BaseResponse.successData(commonUser.getUserId());
		}else{
			return BaseResponse.failMessage("注册失败");
		}
	}

}
