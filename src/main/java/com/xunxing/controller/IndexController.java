package com.xunxing.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xunxing.common.pojo.JsonResult;
import com.xunxing.common.pojo.JsonResultUtil;
import com.xunxing.pojo.OuterBox;
import com.xunxing.service.OuterBoxService;



/**
 * 首页展示Controller
 * <p>Title: IndexController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class IndexController {

	@Autowired
	private OuterBoxService outerBoxService;
	
	
	@ResponseBody
	@RequestMapping("/index")
	public JsonResult showIndex(Model model) {
		
		return JsonResultUtil.getObjectJson("测试");
	}
	
	@RequestMapping("/")
	public String showIndex1(Model model) {
		
		return "index";
	}
	
	
	@ResponseBody
	@RequestMapping("/getOuterBox")
	public JsonResult getOuterBox() {
		
		
		
		PageHelper.startPage(1, 10);
		List<OuterBox> outerBoxList = this.outerBoxService.getOuterBoxList();
		//List<Country> list = countryMapper.selectAll();
		//用PageInfo对结果进行包装
		PageInfo page = new PageInfo(outerBoxList);
		
		
		System.out.println("firstPage:"+page.getFirstPage()+"..."+"list:"+page.getList()+"total:"+page.getTotal());
		
		//System.out.println(outerBoxList.size());
		return JsonResultUtil.getObjectJson(outerBoxList);
	}
	
}
