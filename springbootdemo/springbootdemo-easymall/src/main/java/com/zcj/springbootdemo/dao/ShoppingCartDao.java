package com.zcj.springbootdemo.dao;

import com.zcj.springbootdemo.domain.shoppingcart.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017/4/12.
 */
public interface ShoppingCartDao extends CrudRepository<ShoppingCart,Long> {
}
