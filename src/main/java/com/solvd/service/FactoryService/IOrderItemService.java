package com.solvd.service.FactoryService;


import com.solvd.model.OrderItem;

public interface IOrderItemService {
    OrderItem createOrderItem(OrderItem orderItem);

    OrderItem getOrderItemByID(int orderItemID);
}
