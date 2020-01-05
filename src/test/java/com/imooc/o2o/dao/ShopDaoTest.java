package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;

public class ShopDaoTest extends BaseTest {
	
	@Autowired
	private ShopDao shopDao;
	
	@Test
	public void testInsertShop() {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(7L);
		shopCategory.setShopCategoryId(1L);
		shop.setShopName("Sally-维洛妮");
		shop.setShopDesc("护肤品维洛妮");
		shop.setShopAddr("西安");
		shop.setPhone("15112345678");
		shop.setPriority(1);
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		shop.setOwner(owner);
		shop.setShopCategory(shopCategory);
		shop.setArea(area);
		int effectiveNum = shopDao.insertShop(shop);
		assertEquals(1, effectiveNum);
	}
	
	@Test
	public void testUpdateShop() {
		Shop shop = new Shop();
		Area area = new Area();
		shop.setShopId(2L);
		area.setAreaId(8L);
		shop.setShopDesc("护肤品");
		shop.setShopAddr("凤翔");
		shop.setArea(area);
		int effectiveNum = shopDao.updateShop(shop);
		assertEquals(1, effectiveNum);
	}
}
