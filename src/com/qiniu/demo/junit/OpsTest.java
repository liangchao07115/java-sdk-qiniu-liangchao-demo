package com.qiniu.demo.junit;

import org.junit.Test;

import com.qiniu.common.QiniuException;
import com.qiniu.demo.ops.Ops;
import com.qiniu.http.Response;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;

public class OpsTest {
	
	public Ops ops = new Ops();
	
/*	
public boolean force = true;
	
	public String pipeline = "m3u8";
	
	StringMap params = new StringMap()
			.putWhen("force", 1, force)
			.putNotEmpty("pipeline", "m3u8")
			.put("notifyURL", "demo.qiniu.com");	
				
	String fops = "avthumb/m3u8/segtime/10|saveas/";*/
	
	@Test//文件拼接
	public void test(){
		String url1 = "http://7xj50c.com1.z0.glb.clouddn.com/00ruby.txt";
		String url12 = UrlSafeBase64.encodeToString(url1);
		String mimeType = UrlSafeBase64.encodeToString("text/plain");

		String fops = "concat/mimeType/"+mimeType +"/"+url12;		
		boolean force = true;
		
		StringMap params = new StringMap()
				.putWhen("force", 1, force)
				.putNotEmpty("pipeline", "m3u8");	
		
		try {
			String persistentId = ops.oper("nepliang", "00python.txt",fops,params);
			System.out.println(persistentId);
		} catch (QiniuException e) {
			// TODO Auto-generated catch block
			Response res = e.response;
			try {
				System.out.println(res.bodyString());
			} catch (QiniuException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	

	@Test
	public void test2(){
		boolean force = true;		
		String pipeline = "m3u8";
		
		StringMap params = new StringMap()
				.putWhen("force", 1, force)
				.putNotEmpty("pipeline", "m3u8");
		
		String saveas = "nepliang:00123contact";
		String safeSaveas = UrlSafeBase64.encodeToString(saveas);
		
		String fops = "avthumb/m3u8/segtime/10|saveas/";
		
		String fop = fops + safeSaveas;
		
		String persistentId;
		try {
			persistentId = ops.oper("nepliang", "CDN2015022600027.mpg",fops,params);
			System.out.println(persistentId);
		} catch (QiniuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				System.out.println(e.response.bodyString());
			} catch (QiniuException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
