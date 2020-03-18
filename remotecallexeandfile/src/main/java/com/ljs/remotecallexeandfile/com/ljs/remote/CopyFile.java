package com.ljs.remotecallexeandfile.com.ljs.remote;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class CopyFile {

    public static void main(String[] args) {
        //文件路径
        String basePath = "C:\\Users\\Administrator\\Desktop\\change\\PMLF_TCMA_GD_NEW";
        //输出路径，D盘下
        String outPath = "D" + basePath.substring(1);
        new CopyFile().copy(basePath, outPath);
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
            //输出文件路径
            String utf8FilePath = outPath + file.getAbsolutePath().substring(basePath.length());
            if (file.getName().endsWith(".java")) { //如果是java文件
                try {
                    // 使用GBK读取数据，然后用UTF-8写入数据
                    FileUtils.writeLines(new File(utf8FilePath), "UTF-8", FileUtils.readLines(file, "GBK"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else { //如果不是java文件
                try {
                    FileUtils.writeLines(new File(utf8FilePath), FileUtils.readLines(file));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
