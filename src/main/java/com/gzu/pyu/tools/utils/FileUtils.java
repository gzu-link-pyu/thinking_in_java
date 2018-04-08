package com.gzu.pyu.tools.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class FileUtils
{
    /**
     * 获取当前配置的user.dir绝对路径
     */
    public static final String LOCAL_USER_DIR = System.getProperty("user.dir");

    /**
     * 获取当前配置的temp绝对路径
     */
    public static final String LOCAL_TEMP_DIR = System.getProperty("java.io.tmpdir");

    /**
     * list初始化大小
     */
    public static final int LIST_INITIAL_CAPACITY = 1000;

    /**
     * 文件编码utf-8
     */
    public static final String CODE_UTF_8 = "UTF-8";

    public static final FileUtils INSTANCE = new FileUtils();

    //不用创建实例
    private FileUtils()
    {
    }

    public static FileUtils ref()
    {
        return INSTANCE;
    }

    /**
     * 遍历local文件夹下的所有文件
     * @return 返回System.getProperty("user.dir")文件夹下的所有文件
     */
    public static List<String> traversalLocalDir()
    {
        return traversalAppointDir(LOCAL_USER_DIR);
    }

    /**
     * 遍历local文件夹下指定的目标文件
     * @param targetFileName
     * @param isMatchFind
     * @return
     */
    public static List<String> findLocalTargetFile(String targetFileName, boolean isMatchFind)
    {
        return findAppointTargetFile(LOCAL_USER_DIR, targetFileName, isMatchFind);
    }

    /**
     * 遍历指定的文件夹findDirPath
     * @param traversalDirPath
     * @return 返回指定文件夹下的所有文件
     */
    public static List<String> traversalAppointDir(String traversalDirPath)
    {
        List<String> fileAllList = Collections.synchronizedList(new ArrayList<>());
        traversalDir(traversalDirPath, fileAllList);
        return fileAllList;
    }

    /**
     * 搜索指定路径findDirPath下的目标文件targetFileName
     * isMatchFind=true：支持精确查找
     * isMatchFind=false：支持模糊查找
     * @param findDirPath 搜索的指定路径
     * @return 匹配到的绝对路径集合
     * @throws IllegalArgumentException
     */
    public static List<String> findAppointTargetFile(String findDirPath, String targetFileName, boolean isMatchFind)
            throws IllegalArgumentException
    {
        if (findDirPath == null)
        {
            throw new IllegalArgumentException("findDirPath can not be NULL");
        }

        List<String> fileAllList = Collections.synchronizedList(new ArrayList<>(LIST_INITIAL_CAPACITY));
        //开始对文件夹遍历
        traversalDir(findDirPath, fileAllList);

        //返回匹配的文件路径
        return matchTargetFile(fileAllList, targetFileName, isMatchFind);
    }

    /**
     *
     * @param filePath
     * @return
     */
    public static boolean isFilePath(String filePath)
    {
        if (filePath == null)
        {
            //文件路径不能为null，退出
            return false;
        }

        File findDirFile = new File(filePath);
        //判断文件是否存在
        if (!findDirFile.exists())
        {
            //文件不存在，退出
            return false;
        }
        return true;
    }

    /**
     * 遍历指定的目录
     * @param traversalDirPath 需要遍历的目录
     * @param fileAllList 存遍历结果的list
     */
    private static void traversalDir(String traversalDirPath, List<String> fileAllList)
    {
        if (!isFilePath(traversalDirPath))
        {
            //traversalDirPath 不是一个正确的文件路径
            return;
        }

        File findDirFile = new File(traversalDirPath);
        //判断是文件
        if (findDirFile.isFile())
        {
            fileAllList.add(findDirFile.getAbsolutePath());
            //递归遍历到文件，退出
            return;
        }

        //判断是文件夹
        if (findDirFile.isDirectory())
        {
            File[] childFiles = findDirFile.listFiles();
            if (childFiles != null && childFiles.length > 0)
            {
                Arrays.asList(childFiles).parallelStream().forEach(file ->
                {
                    traversalDir(file.getAbsolutePath(), fileAllList);
                });
            }

            //文件夹为空的时候，退出
            fileAllList.add(findDirFile.getAbsolutePath());
            return;
        }
    }

    /**
     *
     * @param fileAllList 遍历的file
     * @param targetFileName 目标file
     * @param isMatchFind 是否精确查找[true:精确；false:模糊]
     * @return 匹配的目标
     */
    private static List<String> matchTargetFile(List<String> fileAllList, String targetFileName, boolean isMatchFind)
    {
        List<String> fileTargetList = Collections.synchronizedList(new ArrayList<>());
        if (fileAllList != null && fileAllList.size() > 0)
        {
            fileAllList.parallelStream().forEach(path ->
            {

                File tmpFile = new File(path);
                String fileName = tmpFile.getName();

                //模糊查找
                if (!isMatchFind && fileName.contains(targetFileName))
                {
                    fileTargetList.add(path);
                }

                //精确查找
                if (isMatchFind && fileName.equals(targetFileName))
                {
                    fileTargetList.add(path);
                }
            });
        }
        return fileTargetList;
    }

    /**
     * 读取文件的内容
     * @param fileName 文件名
     * @return String
     *
     */
    public static String readFile(String fileName)
            throws IOException
    {
        FileInputStream fis = null;
        try
        {
            if (!isFilePath(fileName))
            {
                return null;
            }

            File file = new File(fileName);
            if (file.isFile() && file.exists())
            {
                file = file.getCanonicalFile();
                fis = new FileInputStream(file);
                byte[] data = new byte[fis.available()];
                int result = fis.read(data);
                return new String(data, CODE_UTF_8);
            }
            return null;
        }
        catch (IOException e)
        {
            throw e;
        }
        finally
        {
            if (fis != null)
            {
                fis.close();
            }
        }
    }

    /**
     * 将字节数组写入文件
     * @param bytes 字节数组
     * @param pathName 输出文件
     * @return boolean 结果
     */
    public static boolean writeBytesToFile(byte[] bytes, String pathName)
    {
        if (!isFilePath(pathName))
        {
            return false;
        }

        return writeBytesToFile(bytes, new File(pathName));
    }

    /**
     * 将字节数组写入文件
     * @param bytes 字节数组
     * @param file 输出文件
     * @return boolean 结果
     */
    public static boolean writeBytesToFile(byte[] bytes, File file)
    {
        if (file == null || !file.exists())
        {
            return false;
        }

        Set<OpenOption> options = new HashSet<>();
        options.add(StandardOpenOption.CREATE);
        options.add(StandardOpenOption.WRITE);
        options.add(StandardOpenOption.TRUNCATE_EXISTING);
        //这里可以设置文件文件的权限
        //Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-------");
        //FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.put(bytes);
        //try (SeekableByteChannel sbc = Files.newByteChannel(file.toPath(), options, attr))
        try (SeekableByteChannel sbc = Files.newByteChannel(file.toPath(), options))
        {
            buffer.flip();
            sbc.write(buffer);
            return true;
        }
        catch (IOException e)
        {
            return false;
        }
    }

    public static void main(String args[])
            throws IOException
    {

        long timeStrat = new Date().getTime();
        List<String> fileTargetList =
                FileUtils.findAppointTargetFile("D:\\", "operation.xml", true);
        long timeEnd = new Date().getTime();
        System.out.println("cost time:" + (timeEnd - timeStrat));
        System.out.println(fileTargetList.size());

        List<String> fileAllList = FileUtils.traversalAppointDir("D:\\");
        System.out.println("cost time:" + (new Date().getTime() - timeEnd));
        System.out.println(fileAllList.size());

    }
}
