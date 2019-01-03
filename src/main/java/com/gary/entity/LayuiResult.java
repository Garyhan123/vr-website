package com.gary.entity;

import java.util.List;

/**
 * 
 * @author xiezerong
 * @date 2018年4月4日 下午12:50:29
 * @Description:layui所需要的格式vo类
 * @param <T>
 */
public class LayuiResult<T> {
	private int code;// 返回码
	private String msg;// 返回信息
	private List<T> data;// 返回数据
	private int count;// 记录条数

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
