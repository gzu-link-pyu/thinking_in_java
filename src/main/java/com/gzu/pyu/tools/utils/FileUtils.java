package com.gzu.pyu.tools.utils;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileUtils {
    /**
     * 获取当前配置的user.dir绝对路径
     */
    public static final String LOCAL_USER_DIR=System.getProperty("user.dir");

    private static List<String> fileAllList= Collections.synchronizedList(new ArrayList<>());

    private static List<String> fileTargetList= Collections.synchronizedList(new ArrayList<>());

    /**
     * 遍历local文件夹下的所有文件
     * @return 返回System.getProperty("user.dir")文件夹下的所有文件
     * @throws IOException
     */
    public static List<String> traversalLocalDir() throws IOException {
        findAppointTargetFile(LOCAL_USER_DIR,null,false);
        return fileAllList;
    }

    /**
     * 遍历local文件夹下指定的目标文件
     * @param targetFileName
     * @param isMatchFind
     * @return
     * @throws IOException
     */
    public static List<String> findLocalTargetFile(String targetFileName,boolean isMatchFind)
            throws IOException {
        findAppointTargetFile(LOCAL_USER_DIR,targetFileName,isMatchFind);
        return fileTargetList;
    }

    /**
     * 遍历指定的文件夹findDirPath
     * @param findDirPath
     * @return 返回指定文件夹下的所有文件
     * @throws IOException
     */
    public static List<String> traversalAppointDir(String findDirPath)
            throws IOException {
        findAppointTargetFile(findDirPath,null,false);
        return fileAllList;
    }

    /**
     * 搜索指定路径findDirPath下的目标文件targetFileName
     * isMatchFind=true：支持精确查找
     * isMatchFind=false：支持模糊查找
     * @param findDirPath 搜索的指定路径
     * @param targetFileName 目标文件
     * @param isMatchFind 是否精确匹配
     * @return 匹配到的绝对路径集合
     * @throws IllegalArgumentException
     * @throws IOException
     */
    public static List<String> findAppointTargetFile(String findDirPath,String targetFileName,boolean isMatchFind)
            throws IllegalArgumentException, IOException {
        if (findDirPath==null||"".equals(findDirPath)){
            throw new IllegalArgumentException("findDirPath can not be NULL");
        }
        //开始对文件夹遍历
        traversalDir(findDirPath,targetFileName,isMatchFind);
        return fileTargetList;
    }

    /**
     * 遍历文件路径
     * @param findDirPath
     * @param targetFileName
     * @param isMatchFind
     * @throws IOException
     */
    private static void traversalDir(String findDirPath,String targetFileName,boolean isMatchFind)
            throws IOException {

        File findDirFile=new File(findDirPath);
        //判断文件是否存在
        if (!findDirFile.exists()){
            throw new IOException(findDirPath+":file not exists.");
        }

        //判断是文件
        if (findDirFile.isFile()){
           matchTargetFile(findDirFile,targetFileName,isMatchFind);
            //递归遍历到文件，退出
            return ;
        }

        //判断是文件
        if (findDirFile.isDirectory()){
            matchTargetFile(findDirFile,targetFileName,isMatchFind);
            //递归遍历文件夹中的文件夹
//            String[] list = findDirFile.list();
//            for (String path:list) {
//                path = findDirPath + File.separator + path;
//                traversalDir(path, targetFileName,isMatchFind);
//            }

            Arrays.asList(findDirFile.listFiles()).parallelStream().forEach(file ->
            {
                try {
                    traversalDir(file.getAbsolutePath(), targetFileName,isMatchFind);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     *
     * @param file 遍历的file
     * @param targetFileName 目标file
     * @param isMatchFind 是否精确查找[true:精确；false:模糊]
     * @throws IOException
     */
    private static void matchTargetFile(File file,String targetFileName,boolean isMatchFind)
            throws IOException {
        //判断文件是否存在
        if (!file.exists()){
            throw new IOException(file+":file not exists.");
        }

        String fileName=file.getName();
        if(targetFileName!=null&&!"".equals(targetFileName)){
            //模糊查找
            if (!isMatchFind && fileName.contains(targetFileName)){
                fileTargetList.add(file.getAbsolutePath());
            }

            //精确查找
            if(isMatchFind && fileName.equals(targetFileName)){
                fileTargetList.add(file.getAbsolutePath());
            }
        }
        //记录所有遍历过的文件
        fileAllList.add(file.getAbsolutePath());
    }

    public static void main(String args[]) {
        int[] a=new int[10];
        for(int i=0;i<=9;i++)
        {
            String str= JOptionPane.showInputDialog("请输入一个整数：");
            a[i]=Integer.parseInt(str);
        }

        int min=a[0];
        int max=a[0];

        for(int n=0;n<=9;n++) {
            if(max<a[n])
                max=a[n];

        }

        for(int j=0;j<=9;j++) {
            if(min>a[0])
                min=a[0];

        }
        System.out.print("max="+max);
        System.out.print("min="+min);
    }
}
