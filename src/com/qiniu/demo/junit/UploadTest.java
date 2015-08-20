package com.qiniu.demo.junit;

import java.io.File;

import org.junit.Test;

import com.qiniu.common.QiniuException;
import com.qiniu.demo.upload.Upload;
import com.qiniu.http.Response;

public class UploadTest {
	private File file = new File("c:" + File.separator + "tt" + File.separator + "README.md");
	
	private String bucket = "qiniu-java-sdk-liangchao-demo";
	
	Upload upload = new Upload();	
	@Test
	public void upload(){		
		/*
		 *auth.uploadToken有四种重载的方法，参考auth类设置
		 *@param bucket  空间名
		 *@param key     key，可为 null
		 *@param expires 有效时长，单位秒。默认3600s
		 *@param policy  上传策略的其它参数，如 new StringMap().put("endUser", "uid").putNotEmpty("returnBody", "")。
		 *scope通过 bucket、key间接设置，deadline 通过 expires 间接设置
		 *@param strict  是否去除非限定的策略字段，默认true
		 *@return 生成的上传token
		 */
		String token =upload.auth.uploadToken(bucket, "01demo", 3600, null, true);
		Response res = upload.uploadDo(file, token, "01demo", null, "text/html", false);
		try {
			System.out.println(res.bodyString());
		} catch (QiniuException e) {
			// TODO Auto-generated catch block
			System.out.println(e.response.statusCode);
		}	
		
	}	

	@Test//图片处理另存get
	public void test(){
		System.out.println(upload.getUrl("7xktma.com1.z0.glb.clouddn.com/00.jpg?imageView2/1/w/100/h/100","nepliang","001"));
	}

}
