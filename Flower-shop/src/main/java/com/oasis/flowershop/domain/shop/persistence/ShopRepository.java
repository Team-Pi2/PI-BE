package com.oasis.flowershop.domain.shop.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository extends JpaRepository<ShopEntity, Long> {

    List<ShopEntity> findAll();

}
