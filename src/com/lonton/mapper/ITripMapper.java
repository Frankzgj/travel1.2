package com.lonton.mapper;

import java.util.ArrayList;


import com.lonton.bean.TripData;
import com.lonton.bean.Picture;
/**
 * 数据操作接口
 * @author 张国军 
 * @date 2015/7/28
 */
public interface ITripMapper {
	/**
	 * 获取景点信息
	 * @return
	 */
	public ArrayList<TripData> getTripData();  
	
	/**
	 * 获取图片信息
	 * @return
	 */
	public ArrayList<Picture> getPicture();
}
