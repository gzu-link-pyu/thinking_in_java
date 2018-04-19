package com.gzu.pyu.tools.utils;

/**
 * 每六位描述一个字节
 * @author zhouzhian
 */
public class UnicodeUtils {

    /**
     * 字符串编码成Unicode编码
     */
    public static String encode(String src){
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < src.length(); i++) {
            // 取出每一个字符
            char c = src.charAt(i);
            // 转换为unicode
            String str = Integer.toHexString(c);
            unicode.append("\\u" + str);
        }
        return unicode.toString();
    }

    /**
     * Unicode解码成字符串
     * @param src
     * @return
     */
    public static String decode(String src) {
        StringBuffer string = new StringBuffer();
        String[] hex = src.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);
            // 追加成string
            string.append((char) data);
        }
        return string.toString();
    }

    public static void main(String[] args) {
        String src="1";
        String str = Integer.toHexString(src.toCharArray()[0]);
        for (int j = 0; j < 4-str.length(); j++) {
            str="0"+str;
        }
        System.out.println(str);
    }
}