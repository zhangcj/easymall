package com.zcj.springbootdemo.service.impl;

import com.zcj.springbootdemo.dao.ItemDao;
import com.zcj.springbootdemo.domain.product.Item;
import com.zcj.springbootdemo.service.inter.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/4/12.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    /**
     * 获取商品列表
     * @return
     */
    @Override
    public Iterable<Item> findAll() {
        Iterable<Item> items = itemDao.findAll();
        return items;
    }

    /**
     * 依据id获取商品
     * @param id
     * @return
     */
    @Override
    public Item findOneById(Long id) {
        return itemDao.findOne(id);
    }
}
