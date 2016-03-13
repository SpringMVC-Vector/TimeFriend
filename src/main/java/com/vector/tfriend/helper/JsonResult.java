package com.vector.tfriend.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * 最外层的字段， 必须的三个字段
 * 
 * @author vector.huang
 * @date 2016年2月26日 上午11:03:16
 */
public class JsonResult {

	private Logger logger = LoggerFactory.getLogger(JsonResult.class);

	private int status;
	private String message;
	private Object data;

	/**
	 * 新建一个默认结果
	 */
	public JsonResult() {
		message = "请求结果为空";
		data = new Object() {
			private String pHK = "pHK";

			public String getPHK() {
				return pHK;
			}

			public void setPHK(String pHK) {
				this.pHK = pHK;
			}

		};
	}

	/**
	 * 转换为JSON
	 * 
	 * @return
	 */
	public String toJson() {
		logger.debug("==== " + JSON.toJSONString(this));
		return JSON.toJSONString(this);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
