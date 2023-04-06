package com.example.onlineOrder.controller;

import com.example.onlineOrder.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
public class ItemOrderController {

    private final OrderItemService orderItemService;

    public ItemOrderController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @RequestMapping(value = "/order/{menuId}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addMenuItemToCart(@PathVariable("menuId") int menuId) {
        orderItemService.saveOrderItem(menuId);
    }
}