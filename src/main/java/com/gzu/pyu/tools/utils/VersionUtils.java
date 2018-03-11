package com.gzu.pyu.tools.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VersionUtils {

	/**
	 * 版本号的正则匹配
	 * 如：1.2.4 /2.35.53.1
	 */
	public static final String VERSION_PATTERN="\\d+(\\.\\d+)*";
	
	/**
	 * 比较两个版本号的大小
	 * @param srcVersion 原版本，不能为空
	 * @param dstVersion 目标版本，不能为空
	 * @return 比较结果
	 * @throws IllegalArgumentException 参数不合法异常
	 */
	public static boolean checkMaxVersion(String srcVersion,String dstVersion)
			throws IllegalArgumentException {
		
		if (srcVersion==null||"".equals(srcVersion)) {
			throw new IllegalArgumentException("srcVersion Argument can not blank");
		}
		
		if (dstVersion==null||"".equals(dstVersion)) {
			throw new IllegalArgumentException("dstVersion Argument can not blank");
		}
		
		
		
		return true;
	}
	
	public static boolean checkVersionPatten(String version) 
			throws IllegalArgumentException{
		
		if (version==null||"".equals(version)) {
			throw new IllegalArgumentException("version Argument can not blank");
		}
			
		return checkStringPatten(version,VERSION_PATTERN);
	}
	
	public static boolean checkStringPatten(String string,String pattern) 
			throws IllegalArgumentException{
		
		if (string==null||"".equals(string)) {
			throw new IllegalArgumentException("str Argument can not blank");
		}
		
		Pattern ptn=Pattern.compile(pattern);		
		Matcher matcher=ptn.matcher(string);	
		
		return matcher.find();
	}
	
    public static void main(String[] args) {
    	
    	System.out.println(checkVersionPatten(""));
		
	}
}
