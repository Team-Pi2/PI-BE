package com.oasis.flowershop.domain.shop.application.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ShopModel {

    private Long shopId;
    private String shopName;
    private String corporationCertNumber;

}
