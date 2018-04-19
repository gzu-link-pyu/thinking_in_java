package com.gzu.pyu.tools.utils;

public class JsonBeanTransferUtils
{
    private static String getLevelStr(int level) {
        StringBuffer levelStr = new StringBuffer();
        for (int i = 0; i < level; i++)
        {
            levelStr.append("\t");
        }
        return levelStr.toString();
    }

    /**
     * 将json字符串装换为格式化json文件
     * @param jsonStr json字符串
     * @return
     */
    public static String formatJsonStr(String jsonStr) {
        int level = 0;
        //存放格式化的json字符串
        StringBuffer jsonForMatStr = new StringBuffer();
        for(int index=0;index<jsonStr.length();index++)//将字符串中的字符逐个按行输出
        {
            //获取s中的每个字符
            char ch = jsonStr.charAt(index);

            //level大于0并且jsonForMatStr中的最后一个字符为\n,jsonForMatStr加入\t
            if (level > 0 && '\n' == jsonForMatStr.charAt(jsonForMatStr.length() - 1)) {
                jsonForMatStr.append(getLevelStr(level));
            }
            //遇到"{"和"["要增加空格和换行，遇到"}"和"]"要减少空格，以对应，遇到","要换行
            switch (ch) {
                case '{':
                case '[':
                    jsonForMatStr.append(ch + "\n");
                    level++;
                    break;
                case ',':
                    jsonForMatStr.append(ch + "\n");
                    break;
                case '}':
                case ']':
                    jsonForMatStr.append("\n");
                    level--;
                    jsonForMatStr.append(getLevelStr(level));
                    jsonForMatStr.append(ch);
                    break;
                default:
                    jsonForMatStr.append(ch);
                    break;
            }
        }
       return jsonForMatStr.toString();
    }
}
