package com.qiniu.demo.ops;

import com.qiniu.common.Config;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Client;
import com.qiniu.http.Response;
import com.qiniu.processing.OperationManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiniu.util.StringUtils;

public class Ops {
	
	private Auth auth = Auth.create(Config.ak, Config.sk);

	private OperationManager operater = new OperationManager(auth);		
	 /**
     * 触发持久化
     * @param bucket 空间名
     * @param key    文件名
     * @param fops   fop指令
     * @param params notifyURL、force、pipeline 等参数
     * @return persistentId
     * @throws QiniuException 触发失败异常，包含错误响应等信息
     */
    public String oper(String bucket, String key, String fops, StringMap params) throws QiniuException{

    	String persistentId = operater.pfop(bucket, key, fops, params);
		return persistentId;
        
    }

	
	
}
