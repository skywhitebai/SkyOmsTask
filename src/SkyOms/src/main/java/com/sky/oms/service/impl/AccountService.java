package com.sky.oms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sky.oms.dao.CommonUserMapper;
import com.sky.oms.dto.response.BaseResponse;
import com.sky.oms.entity.CommonUser;
import com.sky.oms.entity.CommonUserExample;
import com.sky.oms.service.IAccountService;

@Service
public class AccountService implements IAccountService {

	@Autowired
	CommonUserMapper commonUserMapper;
	public BaseResponse<CommonUser> login(String userName, String password) {
		StringBuilder sbErro=new StringBuilder();
		if(StringUtils.isEmpty(userName)){
			sbErro.append("用户名不能为空,");
		}
		if(StringUtils.isEmpty(password)){
			sbErro.append("密码不能为空,");
		}
		if(sbErro.length()>0){
			return BaseResponse.failMessage(sbErro.substring(0,sbErro.length()-1));
		}
		CommonUserExample commonUserExample=new CommonUserExample();
		commonUserExample.createCriteria().andUserNameEqualTo(userName).andPasswordEqualTo(password);
		List<CommonUser> commonUserList=commonUserMapper.selectByExample(commonUserExample);
		if(commonUserList.size()>0){
			return BaseResponse.successData(commonUserList.get(1));
		}
		return BaseResponse.fail("登陆失败，请重新登陆");
	}

}
