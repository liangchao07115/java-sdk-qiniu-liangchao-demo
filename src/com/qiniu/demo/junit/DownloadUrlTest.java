package com.qiniu.demo.junit;

import org.junit.Test;

import com.qiniu.demo.download.Download;

public class DownloadUrlTest {
	
	@Test
	public void downloadPrivate(){
		Download download = new Download();
		String url = download.privateUrl("http://7xjxl7.com1.z0.glb.clouddn.com/1.png");
		
		System.out.println(url);
		
	}

}
