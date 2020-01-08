package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
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
	public void testQueryShopListAndCount(){
	    Shop shopCondition = new Shop();
	    PersonInfo owner = new PersonInfo();
	    ShopCategory shopCategory = new ShopCategory();
	    shopCategory.setShopCategoryId(1L);
	    owner.setUserId(1L);
	    shopCondition.setOwner(owner);
	    shopCondition.setShopCategory(shopCategory);
        List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 5);
        int count = shopDao.queryShopCount(shopCondition);
        System.out.println("店铺列表的大小：" + shopList.size());
        System.out.println("店铺总数为：" + count);
    }
	@Test
    @Ignore
	public void testInsertShop() {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(1L);
		shopCategory.setShopCategoryId(2L);
		shop.setShopName("测试1");
		shop.setShopDesc("护肤品维洛妮");
		shop.setShopAddr("西安");
		shop.setPhone("15112345678");
		shop.setPriority(0);
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核通过");
		shop.setOwner(owner);
		shop.setShopCategory(shopCategory);
		shop.setArea(area);
		int effectiveNum = shopDao.insertShop(shop);
		assertEquals(1, effectiveNum);
	}
	
	@Test
	@Ignore
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
