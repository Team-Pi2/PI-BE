package com.oasis.flowershop.domain.order.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderListResponse {

    private List<OrderInfoResponse> storeInfos;

}
