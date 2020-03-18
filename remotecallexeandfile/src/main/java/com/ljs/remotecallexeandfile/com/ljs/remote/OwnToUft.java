package com.ljs.remotecallexeandfile.com.ljs.remote;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class OwnToUft {
    public static void main(String[] args) {
        try {
            //输入文件
            String input = "F:\\adsf\\index_Ex.jsp";
            // UTF8格式文件路径
            String output = "D:\\index_Ex.jsp";
            // 使用GBK读取数据，然后用UTF-8写入数据
            FileUtils.writeLines(new File(output), "UTF-8", FileUtils.readLines(new File(input), "GBK"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
