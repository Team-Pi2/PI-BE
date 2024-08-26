package com.oasis.flowershop.domain.order.application.model;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderModel {

    private Long orderId;

    private String orderTitle;

    private String orderName;

    private Long price;

    private String script;

    private String imageURL;

    private Category category;

}
