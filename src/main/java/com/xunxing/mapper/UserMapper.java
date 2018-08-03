package com.xunxing.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	/**
	 * 验证用户密码
	 * @param username
	 * @param password des 加密
	 * @return
	 */
	public List<Map> getUserByUserAndPwd(@Param("username")String username,@Param("password")String password);
}
