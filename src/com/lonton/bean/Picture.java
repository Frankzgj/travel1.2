package com.lonton.bean;

/**
 * 从数据库读取出来的数据，包括景点名称，图片路径，景点id
 * @author 张国军
 * @date 2015/7/28
 */
public class Picture {
	
	private String trip_name;
	private String cover;
	private int target_id;
	
	public Picture()
	{
		
	}
	
	public String getTrip_name() {
		return trip_name;
	}
	public void setTrip_name(String trip_name) {
		this.trip_name = trip_name;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public int getTarget_id() {
		return target_id;
	}
	public void setTarget_id(int target_id) {
		this.target_id = target_id;
	}
	
}
