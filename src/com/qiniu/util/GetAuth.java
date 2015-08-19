package com.qiniu.util;

import com.qiniu.common.Config;

public class GetAuth {
	private Auth auth = Auth.create(Config.ak, Config.sk);
	public Auth getAuth() {
		return auth;
	}

}
