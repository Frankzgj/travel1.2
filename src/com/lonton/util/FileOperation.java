package com.lonton.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * 文件操作的工具类，包括创建文件夹，写入文本，下载图片
 * @author 张国军
 * @date 2015/7/28
 */
public class FileOperation {
	/**
	 * 创建文件夹的方法
	 * @param folderName
	 */
	public void makeDirs(String folderName) 
	{
		if (folderName == null || folderName.isEmpty()) 
        {
            return;
        }
        File folder = new File(folderName);
        if(!(folder.exists() && folder.isDirectory())) 
        	folder.mkdirs();
	}
	
	/**
	 * 将信息存入文件
	 * @param txtFile
	 * @param info
	 */
	public void writeText(String txtFile, String info)
	{
		File file = new File(txtFile);
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			if (!file.exists()) 
			{
				file.createNewFile();
			}
			fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			bw.write(info);
            bw.close();  
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}    
	}
	
	/**
	 * 写入图片
	 * @param imgFile
	 * @param outImg
	 */
	public void writeImg(String imgFile, String outImg)
	{
		URL url = null;
		File outFile = new File(outImg);			
		OutputStream os = null;
		InputStream is = null;
		
		try {
			url = new URL(imgFile);
			os = new FileOutputStream(outFile);
			is = url.openStream();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}				
			
		byte[] buff = new byte[1024];				
		while(true) 
		{					
			int readed = 0;
			try{
				readed = is.read(buff);
				if(readed == -1) 
				{						
					break;					
				}				
				byte[] temp = new byte[readed];					
				System.arraycopy(buff, 0, temp, 0, readed);	
				os.write(temp);
			   }catch (IOException e){
				e.printStackTrace();
			  }  
		}
		try {
			is.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}			
}
