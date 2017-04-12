package com.zcj.springbootdemo.controller;

import com.zcj.springbootdemo.api.ShoppingCartServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/4/6.
 */

@Controller
public class ShoppingCartController {

    @Autowired
    private ShoppingCartServiceAPI shoppingCartServiceAPI;

    /**
     * 购物车页面
     * @param shoppingcartid 购物车id
     * @param model
     * @return
     */
    @RequestMapping("/shoppingcart")
    public String shoppingCart(
            @RequestParam(value = "shoppingcartid",required = false,defaultValue = "0") String shoppingcartid,
            Model model) {

        model.addAttribute("shoppingcartid", shoppingcartid);

        shoppingCartServiceAPI.getShoppingCartById(Integer.parseInt(shoppingcartid));
        return "shoppingcart/main";
    }
}
