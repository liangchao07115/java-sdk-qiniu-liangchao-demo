package com.qiniu.demo.download;

import com.qiniu.common.Config;
import com.qiniu.util.Auth;

public class Download {
	
	private Auth auth = Auth.create(Config.ak, Config.sk);
	
	 /**
     * 下载签名
     *
     * @param baseUrl 待签名文件url，如 http://img.domain.com/u/3.jpg 、
     *                http://img.domain.com/u/3.jpg?imageView2/1/w/120
     * @return
     */
	public String privateUrl(String url){
		String provateUrl = auth.privateDownloadUrl(url);		
		return provateUrl;
	}
	
	/**
     * 下载签名
     *
     * @param baseUrl 待签名文件url，如 http://img.domain.com/u/3.jpg 、
     *                http://img.domain.com/u/3.jpg?imageView2/1/w/120
     * @param expires 有效时长，单位秒。默认3600s
     * @return
     */
	public String privateUrl(String baseUrl, long expires){
		String provateUrl = auth.privateDownloadUrl(baseUrl, expires);		
		return provateUrl;
	}
	

}
