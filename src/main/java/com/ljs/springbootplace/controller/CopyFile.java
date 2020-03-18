package com.ljs.springbootplace.controller;

import java.io.*;

public class CopyFile {

    public static void main(String[] args) {
        new CopyFile().copy("D:\\A", "D:\\B");
    }

    /**
     * @Description 复制文件夹到另一个文件夹
     * @Author lx
     * @Date 2020/3/15 11:30
     * @Param basePath 本地待复制的文件夹 outPath目的文件夹
     * @Return
     * @Exception
     */
    public void copy(String basePath, String outPath) {
        //获取本地文件对象
        File baseFile = new File(basePath);
        //对文件夹进行过滤，保留文件
        File[] files = baseFile.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isFile()) {
                    return true;
                } else {
                    copy(file.getAbsolutePath(), outPath + "\\" + file.getName());
                    return false;
                }
            }
        });
        //过滤后的文件夹（里边仅剩文件）
        for (File file : files) {
            //定义输入流
            FileInputStream fileInputStream = null;
            //定义输出流
            FileOutputStream fileOutputStream = null;
            try {
                //输入流读取文件
                fileInputStream = new FileInputStream(file);
                //定义缓存byte数组
                byte[] bytes = new byte[1024];
                //定义一个读取的长度
                int readLenth;
                //如果没有返回-1说明未读取完，循环读取
                while ((readLenth = fileInputStream.read(bytes)) != -1) {
                    //获取输出路径文件
                    //使用mkdir先把不存在的文件夹建出来，再拼接file.getName()
                    File f = new File(outPath);
                    if (!f.exists()) f.mkdirs();
                    fileOutputStream = new FileOutputStream(f.getAbsoluteFile() + "//" + file.getName());
                    //输出流写出
                    fileOutputStream.write(bytes, 0, readLenth);
                    //输出流刷新
                    fileOutputStream.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    //这里注意关闭的顺序，先开的后关闭。
                    //断言，如果输出流不为null
                    assert fileOutputStream != null;
                    fileOutputStream.close();
                    //输入流肯定不为null，所以不需要断言
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
