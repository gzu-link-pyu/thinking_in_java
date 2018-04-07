package com.gzu.pyu.tools.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VersionUtils {

	/**
	 * 默认的版本号的正则匹配
	 * 如：1.2.4 /2.35.53.1.5
	 * \d+(\.\d+){2,3}
	 * \d+     #匹配数字
	 * (\.\d+) #匹配数字之后还有.数字
	 * {2,3}   #表示可以重复2-3次，匹配多次的话换成*
	 */
	public static final String DEFAULT_ERSION_PATTERN="\\d+(\\.\\d+){2,3}";
	
	/**
	 * 比较两个版本号的大小,
	 * 结果大于0，srcVersion大,结果小于0，dstVersion大,等于0，版本号相同
	 * @param srcVersion 原版本，不能为空
	 * @param dstVersion 目标版本，不能为空
	 * @return 比较结果
	 * @throws IllegalArgumentException 参数不合法异常
	 */
	public static int compareToVersion(String srcVersion,String dstVersion)
			throws IllegalArgumentException {
		
		if (srcVersion==null||"".equals(srcVersion)) {
			throw new IllegalArgumentException("srcVersion Argument can not blank");
		}
		
		if (dstVersion==null||"".equals(dstVersion)) {
			throw new IllegalArgumentException("dstVersion Argument can not blank");
		}

		if (!checkVersionPatten(srcVersion)){
			throw new IllegalArgumentException("srcVersion Unmatched default rule");
		}

		if (!checkVersionPatten(dstVersion)){
			throw new IllegalArgumentException("dstVersion Unmatched default rule");
		}

		String[] srcs = srcVersion.split("\\.");
		String[] dsts = dstVersion.split("\\.");

		if (srcs.length-dsts.length>=0){
			for (int i = 0; i < dsts.length; i++) {
				int src = Integer.valueOf(srcs[i]);
				int dst = Integer.valueOf(srcs[i]);
				if ( src - dst == 0 ){
					continue;
				}
				return src-dst;

			}
		}else {
			for (int i = 0; i < srcs.length; i++) {

			}
		}


		return -1;
	}

	/**
	 * 使用默认规则匹配版本号
	 * @param version  版本号，不能为空
	 * @return 比较结果
	 * @throws IllegalArgumentException 参数不合法异常
	 */
	public static boolean checkVersionPatten(String version) 
			throws IllegalArgumentException{

		if (version==null||"".equals(version)) {
			throw new IllegalArgumentException("version Argument can not blank");
		}

		return checkStringPatten(version,DEFAULT_ERSION_PATTERN);
	}

	/**
	 * 按传入的规则，匹配字符串
	 * @param str  字符串
	 * @param pattern 匹配规则
	 * @return 匹配结果
	 * @throws IllegalArgumentException 参数不合法异常
	 */
	public static boolean checkStringPatten(String str,String pattern)
			throws IllegalArgumentException{
		
		if (str==null||"".equals(str)) {
			throw new IllegalArgumentException("Input string Argument can not blank");
		}
		
		Pattern ptn=Pattern.compile(pattern);		
		Matcher matcher=ptn.matcher(str);

		return matcher.matches();
	}
	
    public static void main(String[] args) {

		String[] srcs = "1.2.3".split("\\.");
		String[] dsts = "2.3.4".split("\\.");
	}
}
