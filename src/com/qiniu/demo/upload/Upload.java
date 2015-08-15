package com.qiniu.demo.upload;

import com.qiniu.common.Config;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class Upload {

	public Auth auth = Auth.create(Config.ak, Config.sk);
	
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
	
	
	
	
}
