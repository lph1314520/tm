package com.xunxing.controller;




import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xunxing.common.pojo.CommonParams;
import com.xunxing.common.pojo.JsonResult;
import com.xunxing.common.pojo.JsonResultUtil;
import com.xunxing.common.util.DesUtil;
import com.xunxing.common.util.StringUtil;
import com.xunxing.pojo.OuterBox;
import com.xunxing.service.OuterBoxService;
import com.xunxing.service.UserService;



/**
 * 首页展示Controller
 * <p>Title: IndexController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
@RequestMapping("/outerBox")
public class OuterBoxController {

	@Autowired
	private OuterBoxService outerBoxService;
	
	@Autowired
	private UserService userService;
	
	
	@ResponseBody
	@RequestMapping("/getOuterBox")
	public JsonResult getOuterBox(String username,String password) {
		
		if(StringUtil.isEmpty(username)) {
			return JsonResultUtil.getErrorJson("用户名不能为空");
			//throw new  RuntimeException("用户名不能为空");
		}
		if(StringUtil.isEmpty(password)) {
			return JsonResultUtil.getErrorJson("密码不能为空");
			//throw new  RuntimeException("密码不能为空");
		}
		
		
		if(!this.userService.validateUser(username, password)) {
			return JsonResultUtil.getErrorJson("用户名或密码错误");
			//throw new  RuntimeException("用户名或密码错误!");
		}
		
		PageHelper.startPage(1, 10);
		List<OuterBox> outerBoxList = this.outerBoxService.getOuterBoxList();
		//List<Country> list = countryMapper.selectAll();
		//用PageInfo对结果进行包装
		//PageInfo page = new PageInfo(outerBoxList);
		
		return JsonResultUtil.getObjectJson(outerBoxList);
	}
	
	public static void main(String[] args) {
		Charset charset = Charset.forName("utf-8");
	    String str = "000";
	    String encryptResult = DesUtil.encrypt(str, charset, CommonParams.ENCRYPTOR_KEY);
		System.out.println(encryptResult);
	}
	
}
