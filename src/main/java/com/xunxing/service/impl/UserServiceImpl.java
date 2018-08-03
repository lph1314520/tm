package com.xunxing.service.impl;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xunxing.common.pojo.CommonParams;
import com.xunxing.common.util.DesUtil;
import com.xunxing.mapper.UserMapper;
import com.xunxing.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserMapper userMapper;
	
	public boolean validateUser(String username, String password) {
		// TODO Auto-generated method stub
		Charset charset = Charset.forName("utf-8");
		password = DesUtil.encrypt(password, charset, CommonParams.ENCRYPTOR_KEY);
		
		 List<Map> userList = userMapper.getUserByUserAndPwd(username, password);
		 
		 return (userList!=null && userList.size()>0);
	}

	

	
	



}
