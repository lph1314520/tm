package com.xunxing.common.pojo;




import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * json结果工具类<br>
 * 用于控制器返回json使用<br>
 * spring mvc的@ResponseBody自动将Map 转为json<br>
 * json格式符合javashop规范：<br>
 * {"result":1,"message":""}或<br>
 * {"result":1,"data":""}或<br>
 *  适用于grid的： {"total":1,"rows":""}<br>

 */
public class JsonResultUtil {
	

	
	/**
	 * 获取对象json Map
	 * @param object 要生成json格式的对象
	 * @return 符合javashop规范的json map: {"result":1,"data":""}
	 */
	public static JsonResult getObjectJson(Object object){
	 
		JsonResult result = new JsonResult();
		result.setResult(1);
		result.setData(object);
	  
		return result;
		
	}
	
	public static JsonResult getObjectJson(Object msg,Object object){
		 
		JsonResult result = new JsonResult();
		result.setResult(1);
		result.setMessage(msg.toString());
		result.setData(object);
	  
		return result;
		
	}
	
	/**
	 * 获取对象json Map
	 * @param object 要生成json格式的对象
	 * @objectName	object的key名称
	 * @return 符合javashop规范的json map: {"result":1,"data":""}
	 */
	public static JsonResult getObjectJson(Object object, String objectName){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(objectName, object);
		JsonResult result = new JsonResult();
		result.setResult(1);
		result.setData(map);
	  
		return result;
		
	}
	
	/**
	 * 获得对象json Integer
	 * @param name 数值key名
	 * @param num 值
	 * @return 符合javashop规范的json map: {"result":1,"data":""}
	 */
	public static JsonResult getNumberJson(String name, int num){
	 
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put(name, num);
		
		JsonResult result = new JsonResult();
		result.setResult(1);
		result.setData(map);
	  
		return result;
		
	}
	
	
	/**
	 * 获取成功状态的json Map
	 * @param message 要返回的信息
	 * @return 符合javashop规范的json map: {"result":1,"message":""}
	 */	
	public static JsonResult getSuccessJson(String message){
		
		JsonResult result = new JsonResult();
		result.setResult(1);
		result.setMessage(message);
		
		return result;
	}
	
	/**2017-02-10陈根榕
	 * 获取第二种成功状态的json Map
	 * @param message 要返回的信息
	 * @return 符合javashop规范的json map: {"result":1,"message":""}
	 */	
	public static JsonResult getSuccessCustomJson(String message){
		
		JsonResult result = new JsonResult();
		result.setResult(11);
		result.setMessage(message);
		
		return result;
	}
	
	/**
	 * 获取失败状态的json Map
	 * @param message 要返回的信息
	 * @return 符合javashop规范的json map: {"result":0,"message":""}
	 */	
	public static JsonResult getErrorJson(String message){
		
		JsonResult result = new JsonResult();
		result.setResult(0);
		result.setMessage(message);
		 
		return result;
		
	}
	
}
