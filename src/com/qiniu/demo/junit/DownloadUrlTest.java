package com.qiniu.demo.junit;

import org.junit.Test;

import com.qiniu.demo.download.Download;

public class DownloadUrlTest {
	public Download download = new Download();
	public String baseurl  = "http://7xjxl7.com1.z0.glb.clouddn.com/1.png";
	
	@Test
	public void downloadPrivate(){		
		String url = download.privateUrl(baseurl);
		System.out.println(url);		
	}
	
	@Test
	public void setTime(){
		String url = download.unixTimeStampUrl("2015/08/20 22:05:00", baseurl);
		System.out.println(url);
	}

}
