package com.zcj.springbootdemo.dao;

import com.zcj.springbootdemo.domain.product.Item;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017/4/12.
 */
public interface ItemDao extends CrudRepository<Item, Long> {
}
