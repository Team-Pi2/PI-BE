package com.oasis.flowershop.domain.order.persistence;

import com.oasis.flowershop.domain.order.application.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Query("SELECT o FROM OrderEntity o WHERE o.category=:category")
    List<OrderEntity> findAll(@Param("category") Category category);

}
