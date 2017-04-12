package com.zcj.springbootdemo.service.inter;

import com.zcj.springbootdemo.domain.product.Item;

/**
 * Created by Administrator on 2017/4/12.
 */
public interface ItemService {

    /**
     * 获取所有商品
     * @return
     */
    Iterable<Item> findAll();

    /**
     * 依照id获取实体
     * @param id
     * @return
     */
    Item findOneById(Long id);
}
