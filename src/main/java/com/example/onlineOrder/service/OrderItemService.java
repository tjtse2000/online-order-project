package com.example.onlineOrder.service;

import com.example.onlineOrder.dao.OrderItemDao;
import com.example.onlineOrder.entity.Customer;
import com.example.onlineOrder.entity.MenuItem;
import com.example.onlineOrder.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    private final MenuInfoService menuInfoService;
    private final CustomerService customerService;
    private final OrderItemDao orderItemDao;

    @Autowired
    public OrderItemService(MenuInfoService menuInfoService, CustomerService customerService, OrderItemDao orderItemDao) {
        this.menuInfoService = menuInfoService;
        this.customerService = customerService;
        this.orderItemDao = orderItemDao;
    }

    public void saveOrderItem(int menuId) {
        OrderItem orderItem = new OrderItem();
        MenuItem menuItem = menuInfoService.getMenuItem(menuId);

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        Customer customer = customerService.getCustomer(username);

        orderItem.setMenuItem(menuItem);
        orderItem.setCart(customer.getCart());
        orderItem.setQuantity(1);
        orderItem.setPrice(menuItem.getPrice());
        orderItemDao.save(orderItem);
    }
}