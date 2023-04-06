package com.example.onlineOrder.controller;

import com.example.onlineOrder.entity.Cart;
import com.example.onlineOrder.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    @ResponseBody
    public Cart getCart(){
        return cartService.getCart();
    }
}