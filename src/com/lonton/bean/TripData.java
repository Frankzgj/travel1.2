package com.lonton.bean;

import net.sf.json.JSONObject;

/**
 * 从数据库读取出来的数据，包括景点名字，景点ID，景点简介，所在省份，所在城市
 * @author 张国军
 * @date 2015/7/16
 */
public class TripData {
	private int target_Id;
	private String target_Name;
	private String desc;
	private String province_Name;
	private String city_Name;


	public TripData() {
	}


	public String getTarget_Name() {
		return target_Name;
	}


	public void setTarget_Name(String target_Name) {
		this.target_Name = target_Name;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public int getTarget_Id() {
		return target_Id;
	}


	public void setTarget_Id(int target_Id) {
		this.target_Id = target_Id;
	}


	public String getProvince_Name() {
		return province_Name;
	}


	public void setProvince_Name(String province_Name) {
		this.province_Name = province_Name;
	}


	public String getCity_Name() {
		return city_Name;
	}


	public void setCity_Name(String city_Name) {
		this.city_Name = city_Name;
	}


	public String toJsonString(TripData dt) {
		// 信息按json的格式处理
		JSONObject jsonObject = JSONObject.fromObject(dt);
		String info = jsonObject.toString();
		return info;
	}

}
