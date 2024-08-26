package com.oasis.flowershop.domain.order.application.service;

import com.oasis.flowershop.domain.order.application.model.Category;
import com.oasis.flowershop.domain.order.application.model.OrderModel;
import com.oasis.flowershop.domain.order.application.model.OrderModelConverter;
import com.oasis.flowershop.domain.order.persistence.OrderEntity;
import com.oasis.flowershop.domain.order.persistence.OrderRepository;
import com.oasis.flowershop.domain.shop.application.model.ShopModel;
import com.oasis.flowershop.domain.order.application.usecase.OrderListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderListUseCase {

    private final OrderRepository orderRepository;
    private final OrderModelConverter orderModelConverter;

    @Override
    public List<OrderModel> findAll(String category) {
        Category query = Category.findCategory(category);
        List<OrderEntity> entities = orderRepository.findAll(query);
        List<OrderModel> models = entities.stream().map(orderModelConverter::from).collect(Collectors.toList());
        return models;
    }

    public OrderModel order(){
        
        return null;
    }


}
