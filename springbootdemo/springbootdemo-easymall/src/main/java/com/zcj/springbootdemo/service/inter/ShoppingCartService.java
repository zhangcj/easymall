package com.zcj.springbootdemo.service.inter;

import com.zcj.springbootdemo.domain.shoppingcart.ShoppingCart;

/**
 * Created by Administrator on 2017/4/12.
 */
public interface ShoppingCartService {

    /**
     * 创建新购物车记录
     * @param shoppingCart
     * @return
     */
    ShoppingCart addToShoppingCart(ShoppingCart shoppingCart);
}
