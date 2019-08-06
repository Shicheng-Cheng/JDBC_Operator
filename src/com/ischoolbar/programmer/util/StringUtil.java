package com.ischoolbar.programmer.util;

import java.util.List;

public class StringUtil {
	public static boolean isEmpty(String str) {
		if(str==null || "".equals(str)) return true;
		return false;
			
	}
	public static String convertToundercase(String str) {
		if(isEmpty(str)) return null;
		String retString="";
		for(int i=0;i<str.length();i++) {
			char charat=str.charAt(i);
			if(Character.isUpperCase(charat)) {
				if(i==0) {
					retString+=String.valueOf(charat).toLowerCase();
					continue;
				}
				retString+="_"+String.valueOf(charat).toLowerCase();
				continue;
				
			}
			retString+=charat;
		}
		return retString;
	}
	/*
	 * 按照要求将字符数组进行分割
	 */
	public static String join(List<String > list,String split) {
		String reString="";
		for(Object obj:list) {
			reString+=obj+split;
			
		}
		reString=reString.substring(0,reString.lastIndexOf(split));
		return reString;
		
	}

}
