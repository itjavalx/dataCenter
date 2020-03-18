package com.ljs.remotecallexeandfile.com.ljs.remote;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

/**
 * @ClassName : ProjectGbkToUtf8
 * @Description: 将整个工程所有代码的编码由GBK转为UTF-8
 * @author : jw.Li
 * @date 2019年8月30日 下午1:41:03
 */
public class ProjectGbkToUtf8111 {

	/** 最父级顶端的路径 */
	private static final String FINAL_PATH = "E:" + File.separator
	        + "IdeaProjects" + File.separator + "ts-biz-nwgh-old"
	        + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator
	        + "";

	/** 公司域名命名的包路径 */
	private static final String MIDDLE_PATH = "com" + File.separator + "tsingsoft" + File.separator;

	public static void main(String[] args) {
		//String dirPath = FINAL_PATH + MIDDLE_PATH;
		String dirPath = "E:\\IdeaWorkSpace\\data_center\\src\\main\\java\\com\\tsingsoft\\querydata\\db";
		System.out.println("开始寻找文件夹在：【" + dirPath + "】内的Java文件");
		new ProjectGbkToUtf8111().doCodingChange(dirPath);

	}

	/**
	 * @Description: 做编码转换
	 * @param dirPath
	 * @date 2019年8月30日 下午1:43:40
	 */
	private void doCodingChange(String dirPath) {
		try {
			String utf8DirPath = "D" + dirPath.substring(1);
			// 获取所有java文件
			Collection<File> javaGbkFileCol = FileUtils.listFiles(new File(dirPath), new String[] { "java" }, true);
			for (File javaGbkFile : javaGbkFileCol) {
				// UTF8格式文件路径
				String utf8FilePath = utf8DirPath + javaGbkFile.getAbsolutePath().substring(dirPath.length());
				// 使用GBK读取数据，然后用UTF-8写入数据
				FileUtils.writeLines(new File(utf8FilePath), "UTF-8", FileUtils.readLines(javaGbkFile, "GBK"));
			}

		}
		catch (Exception e) {
			System.out.println(dirPath);
			e.printStackTrace();
		}
	}

}
