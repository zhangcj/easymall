package com.zcj.springbootdemo.controller;

import com.zcj.springbootdemo.domain.product.Item;
import com.zcj.springbootdemo.domain.shoppingcart.ShoppingCart;
import com.zcj.springbootdemo.service.inter.ItemService;
import com.zcj.springbootdemo.service.inter.ShoppingCartService;
import org.hibernate.annotations.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/12.
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    private final int userId = 111;

    @Autowired
    private ItemService itemService;
    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String itemList(Model model){
        Iterable<Item> items = itemService.findAll();
        model.addAttribute("items",items);

        return "item/list";
    }

    @RequestMapping(value = "/submit",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String submitItem(
            @RequestParam(value = "ids") String ids){
        if(ids.length()>0){
            String[] idArr = ids.split(",");

            ShoppingCart shoppingCart;
            Item item;
            for (int i = 0 ; i <idArr.length ; i++ ) {
                if(idArr[i].length()>0){
                    item = itemService.findOneById(Long.parseLong(idArr[i]));

                    shoppingCart = new ShoppingCart();
                    shoppingCart.setItemId(Long.parseLong(idArr[i]));
                    shoppingCart.setItemName(item.getItemName());
                    shoppingCart.setPrice(1*item.getPrice());
                    shoppingCart.setCount(1);
                    shoppingCart.setCreatedAt(new Date());
                    shoppingCartService.addToShoppingCart(shoppingCart);
                }
            }
        }
        return "item/success";
    }
}
