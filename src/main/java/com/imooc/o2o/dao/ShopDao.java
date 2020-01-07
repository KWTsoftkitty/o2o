package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Shop;

public interface ShopDao {
	/**
	 * 新增店铺
	 * @param shop
	 * @return
	 */
	int insertShop(Shop shop);
	
	/**
	 * 更新店铺
	 * @param shop
	 * @return
	 */
	int updateShop(Shop shop);
	
	/**
	 * 通过shop id查询店铺
	 * @param shopId
	 * @return shop
	 */
	Shop queryByShopId(long shopId);
}
