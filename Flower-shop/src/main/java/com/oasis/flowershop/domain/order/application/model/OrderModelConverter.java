package com.oasis.flowershop.domain.order.application.model;

import com.oasis.flowershop.domain.order.persistence.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderModelConverter {

    public OrderModel from(OrderEntity source){
        return OrderModel.builder()
                .orderId(source.getOrderId())
                .price(source.getPrice())
                .orderName(source.getSeller())
                .orderTitle(source.getOrderTitle())
                .script(source.getScript())
                .imageURL(source.getImageUrl())
                .category(source.getCategory())
                .build();
    }

}
