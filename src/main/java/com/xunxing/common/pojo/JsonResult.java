package com.xunxing.common.pojo;




/**
 * 用于生成Json格式 结果对象<br>
 * 一般用于一次http的ajax请求的json返回<br>
 * {"result":1,"message":""}或<br>
 * {"result":1,"data":""}或<br>
 * @author lph
 * @version v1.0
 * 2017年09月20日下午4:47:00
 * @since v6.0
 */
public class JsonResult {
	
	/**
	 * 请求结果，0为失败，1为成功
	 */
	private int result; 
	
	
	/**
	 * 请求结果信息
	 */
	private String message;
	
	
	/**
	 * 请求的返回数据对象，也将被转为json格式
	 */
	private Object data;
	
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	
	
}
