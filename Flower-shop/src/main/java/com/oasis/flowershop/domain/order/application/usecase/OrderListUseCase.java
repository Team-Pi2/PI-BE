package com.oasis.flowershop.domain.order.application.usecase;

import com.oasis.flowershop.domain.order.application.model.OrderModel;
import com.oasis.flowershop.domain.shop.application.model.ShopModel;

import java.util.List;

public interface OrderListUseCase {

    List<OrderModel> findAll(String category);

}
