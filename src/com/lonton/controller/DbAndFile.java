package com.lonton.controller;

import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lonton.bean.TripData;
import com.lonton.bean.Picture;
import com.lonton.mapper.ITripMapper;
import com.lonton.service.FileDirs;
/**
 * 整个程序的入口
 * @author 张国军
 * @data 2015/7/28
 */
public class DbAndFile {
	
	//定义对象
	private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    //静态快初始化
    static {
        try {
            reader = Resources.getResourceAsReader("conf.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 完成创建文件夹、写入数据
     */
	public void control() 
	{
		
		FileDirs fd = new FileDirs();
		SqlSession session = sqlSessionFactory.openSession();
		
		//将从数据库取得的数据实例化
		ITripMapper userOperation = session.getMapper(ITripMapper.class);
		ArrayList<Picture> pictures = userOperation.getPicture();
		ArrayList<TripData> datas = userOperation.getTripData();
		
		//得到一个景点中的多张图片
        ArrayList<String> cover = new ArrayList<String>();
        for(TripData data : datas)
        { 
        	cover.clear();
	        for(Picture picture: pictures )
	        {
	        	if(data.getTarget_Id() == picture.getTarget_id())
	        	{
	        		cover.add(picture.getCover());
	        	}
	        }
	        //创建文件夹及写入数据
	        fd.makeDirsAndWrite(data,cover);
        }
	}
}
