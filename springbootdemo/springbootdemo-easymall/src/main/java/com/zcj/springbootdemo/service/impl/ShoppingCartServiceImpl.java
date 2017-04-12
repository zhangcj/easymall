package com.zcj.springbootdemo.service.impl;

import com.zcj.springbootdemo.dao.ShoppingCartDao;
import com.zcj.springbootdemo.domain.shoppingcart.ShoppingCart;
import com.zcj.springbootdemo.service.inter.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/12.
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartDao shoppingCartDao;

    /**
     * 创建购物车记录
     * @param shoppingCart
     * @return
     */
    @Override
    public ShoppingCart addToShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartDao.save(shoppingCart);
    }
}
