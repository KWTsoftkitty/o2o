package com.imooc.o2o.utils;

public class PathUtil {
	private static String seperator = System.getProperty("file.separator");

	/**
	 * 项目图片保存的绝对路径
	 * 
	 * @return
	 */
	public static String getImgBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = "D:/projectdev/image/";
		} else {
			basePath = "/Users/kwt/javaprojects/o2o/image/";
		}
		basePath = basePath.replace("/", seperator);
		return basePath;
	}

	/**
	 * 获取用户上传图片的相对路径
	 * 
	 * @param shopId
	 * @return
	 */
	public static String getShopImagePath(long shopId) {
		String imagePath = "/upload/item/shop/" + shopId + "/";
		return imagePath.replace("/", seperator);
	}
}
