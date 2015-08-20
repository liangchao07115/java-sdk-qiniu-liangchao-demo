package com.qiniu.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date2UnixTimestamp {
	public static long DateFomat(String str){		
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String dateString = str;
		Date date = new Date();
		try {
			date = df.parse(dateString);
		} catch (ParseException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long k = date.getTime();	
		return k/1000;
	}

}
