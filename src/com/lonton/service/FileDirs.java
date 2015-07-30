package com.lonton.service;





import java.util.ArrayList;

import com.lonton.bean.TripData;
import com.lonton.util.FileOperation;

/**
 * 创建存储路径，并将信息存入文件
 * @author 张国军
 * @date 2015/7/17
 */
public class FileDirs {
	
	FileOperation fileOperation = new FileOperation();
	
	/**
	 * 创建存储路径,包括文本和图片的
	 * @param dt
	 * @param cover	
	 */
	public void makeDirsAndWrite(TripData dt,ArrayList<String> cover) 
	{
		//得到从数据库读取的值
		int id = dt.getTarget_Id();
		String name = dt.getTarget_Name();
		String province = dt.getProvince_Name();
		String city= dt.getCity_Name();
		
		//创建存储路径
        String folderName = "E:\\info\\" + province + "\\" + city + "\\" + name;
        fileOperation.makeDirs(folderName);
        
        //写入图像文件
        String imgDir = folderName + "\\" + name + "(" + cover.size() + ")";
        fileOperation.makeDirs(imgDir);
        int size = cover.size();
        if(!cover.isEmpty())
        {
	        for(int i = 0; i < size; i++)
	        {
	        	String imgFile = imgDir + "\\" + name + (i + 1) + ".jpg";
	        	String url = "http://121.40.142.220:8082/justforhelp_fileservice/files" + cover.get(i);
	        	fileOperation.writeImg(url,imgFile);
	        }
        }
        
        //txt文本路径
        String txtFile = folderName + "\\" + name + "(" + id + ").txt";
        //得到Json处理的信息
        String info = dt.toJsonString(dt);
        //写入文件
        fileOperation.writeText(txtFile, info);
	}
	
}
