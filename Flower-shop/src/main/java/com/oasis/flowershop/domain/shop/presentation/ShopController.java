package com.oasis.flowershop.domain.shop.presentation;

import com.oasis.flowershop.domain.shop.application.model.ShopModel;
import com.oasis.flowershop.domain.order.application.usecase.OrderListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shops")
public class ShopController {

    @GetMapping
    public ResponseEntity<String> getShopList(){
        return new ResponseEntity("test", HttpStatus.OK);
    }

}
