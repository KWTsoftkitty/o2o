package com.imooc.o2o.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;

public interface ShopService {

    /**
     * 查询店铺列表
     *
     * @param shopCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);

    /**
     * 添加店铺
     *
     * @param shop
     * @param shopImg 店铺图片
     * @return
     */
    ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);

    /**
     * 根据shop id获取店铺信息
     *
     * @param shopId
     * @return shop
     */
    Shop getByShopId(long shopId);

    /**
     * 更新店铺信息，包括对图片的处理
     *
     * @param shop
     * @param shopImg
     * @return
     */
    ShopExecution modifyShop(Shop shop, CommonsMultipartFile shopImg);
}
