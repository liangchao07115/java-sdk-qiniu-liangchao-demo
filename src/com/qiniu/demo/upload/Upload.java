package com.qiniu.demo.upload;
import java.io.File;
import org.junit.Test;
import com.qiniu.common.Config;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

/*文件上传*/
public class Upload {
	/*
	 * Auth 类可设置获取token，制定putPolicy
	 */
	public Auth auth = Auth.create(Config.ak, Config.sk);
	
	/**
	 * UploadManager类实现put方法实现上传。
	 */
	public UploadManager uploadManager = new UploadManager();

	public Upload() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Upload(Auth auth, UploadManager uploadManager) {
		super();
		this.auth = auth;
		this.uploadManager = uploadManager;
	}		
	
	/**
	 * 上传文件
	 * UploadManager的put方法有六种重载
     * @param file     上传的文件对象
     * @param token    上传文件的token,Auth类中uploadToken方法获取token
     * @param key      上传文件保存的文件名，如果token中指定key,要与此处的key保持一致
     * @param params   参考使用：http://developer.qiniu.com/docs/v6/api/overview/up/response/vars.html#xvar，可为null		
     * @param mime     指定文件mimetype
     * @param checkCrc 是否验证crc32 
     */
	public Response uploadDo(File file, String token, String key,StringMap params,String mime,boolean checkCrc){		
		try {
			Response res = uploadManager.put(file, key, token, params, mime, checkCrc);
			return res;
		} catch (QiniuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Response re = e.response;
			return re;
		}			
	}	
	
}
