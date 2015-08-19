package com.qiniu.demo.rs;

import java.util.ArrayList;
import com.qiniu.common.Config;
import com.qiniu.common.QiniuException;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.storage.model.FileListing;
import com.qiniu.util.Auth;

public class SourceManager {
	private Auth auth = Auth.create(Config.ak, Config.sk);
	//空间资源管理
	private BucketManager bucketManager = new BucketManager(auth);
	
	/**
     * @return bucket 列表
	 * @throws QiniuException 
     */
	public String[] listBucketName() throws QiniuException{
		String[] buckets = bucketManager.buckets();
		return buckets;
	}
	
	 /**
     * 根据前缀获取文件列表
     *
     * @param bucket    空间名
     * @param prefix    文件名前缀
     * @param marker    上一次获取文件列表时返回的 marker
     * @param limit     每次迭代的长度限制，最大1000，推荐值 100
     * @param delimiter 指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
     * @return
     * @throws QiniuException
     */
	public ArrayList<String> listFilesName(String bucket, String prefix, String marker, int limit, String delimiter) throws QiniuException {
		FileListing fileListing = bucketManager.listFiles(bucket, prefix, marker, limit, delimiter);

		FileInfo[] item = fileListing.items;

		ArrayList<String> list = new ArrayList<String>();

		for (FileInfo value : item) {
			System.out.println(value.key);
			list.add(value.key);
		}
		return list;
	}
	
	 /**
     * 获取指定空间、文件名的状态
     * @param bucket
     * @param key
     */
	public FileInfo statFile(String bucket, String key) throws QiniuException{		
		FileInfo fileInfo = bucketManager.stat(bucket, key);		
		return fileInfo;
	}
	
	/**
     * 复制文件。要求空间在同一账号下。
     * @param from_bucket
     * @param from_key
     * @param to_bucket
     * @param to_key
     */
  
	public boolean copy(String from_bucket, String from_key, String to_bucket, String to_key){        
    	try {
			bucketManager.copy(from_bucket, from_key, to_bucket, to_key);
			return true;
		} catch (QiniuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    	
    }    
    
    /**
     * 移动文件。要求空间在同一账号下。
     *
     * @param from_bucket
     * @param from_key
     * @param to_bucket
     * @param to_key
     */
   

	public boolean move(String from_bucket, String from_key, String to_bucket, String to_key){
    	
        try {
			bucketManager.move(from_bucket, from_key, to_bucket, to_key);
			return true;
		} catch (QiniuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	return false;
    }
    
    
    /**
     * 重命名文件。要求空间在同一账号下。
     *
     * @param bucket
     * @param from_key
     * @param to_key
     */

    
    public boolean remove(String bucket, String from_key, String to_key){        
		boolean b = move(bucket, from_key, bucket, to_key);		
		return b;
    }
    
    

    /**
     * 
     * 删除指定空间、文件名的文件
     * @param bucket
     * @param key
     */
    public boolean delete(String bucket, String key){
        try {
			bucketManager.delete(bucket, key);
			return true;
		} catch (QiniuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
    
	
    //批量操作buckeManager的batch方法
    
    /**
     * @param url 公网可访问的url
     * @param bucket 空间名
     * @param key 指定的文件名
     */
    public DefaultPutRet fetch(String url, String bucket,String key) throws QiniuException {
        return bucketManager.fetch(url, bucket, key);
    }
    
    
    /**
     *更新镜像源 
     * @param bucket
     * @param key
     */
    public void prefetch(String bucket, String key) throws QiniuException {
        bucketManager.prefetch(bucket, key);
    }

	

    
}
