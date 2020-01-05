package com.imooc.o2o.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;

public interface ShopService {
	
	/**
	 * 添加店铺
	 * @param shop
	 * @param shopImg 店铺图片
	 * @return
	 */
	ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);
}
