package com.oasis.flowershop.domain.order.presentation;

import com.oasis.flowershop.common.presentation.response.ApiResponse;
import com.oasis.flowershop.common.presentation.response.ApiResponseBody.*;
import com.oasis.flowershop.common.presentation.response.ApiResponseGenerator;
import com.oasis.flowershop.common.presentation.response.MessageCode;
import com.oasis.flowershop.domain.order.application.dto.OrderListResponse;
import com.oasis.flowershop.domain.order.application.dto.converter.OrderResponseConverter;
import com.oasis.flowershop.domain.order.application.model.OrderModel;
import com.oasis.flowershop.domain.order.application.usecase.OrderListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderResponseConverter orderResponseConverter;
    private final OrderListUseCase orderListUseCase;

    @GetMapping
    public ApiResponse<SuccessBody<OrderListResponse>> findOrders(
            @RequestParam("category") String category
    ){
        List<OrderModel> orders = orderListUseCase.findAll(category);
        OrderListResponse response = OrderListResponse.builder()
                .storeInfos(orders.stream().map(orderResponseConverter::from).collect(Collectors.toList())).build();
        return ApiResponseGenerator.success(response, HttpStatus.OK, MessageCode.GET);
    }

}
