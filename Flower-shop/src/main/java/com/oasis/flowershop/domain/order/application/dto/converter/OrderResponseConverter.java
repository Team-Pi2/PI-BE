package com.oasis.flowershop.domain.order.application.dto.converter;

import com.oasis.flowershop.domain.order.application.dto.OrderInfoResponse;
import com.oasis.flowershop.domain.order.application.model.OrderModel;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseConverter {

    public OrderInfoResponse from(OrderModel source){
        return OrderInfoResponse.builder()
                .id(source.getOrderId())
                .title(source.getOrderTitle())
                .price(source.getPrice())
                .imageURL(source.getImageURL())
                .name(source.getOrderName())
                .script(source.getScript())
                .category(source.getCategory().toString())
                .build();
    }

}
