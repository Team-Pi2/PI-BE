package com.oasis.flowershop.domain.order.persistence;

import com.oasis.flowershop.common.persistence.BaseEntity;
import com.oasis.flowershop.domain.order.application.model.Category;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@SuperBuilder(toBuilder = true)
@Entity
@Table(name = OrderEntity.ENTITY_PREFIX)
@SQLDelete(sql = "UPDATE consumer_order SET is_deleted=true where order_id=?")
@Where(clause = "is_deleted=false")
public class OrderEntity extends BaseEntity {

    public static final String ENTITY_PREFIX = "consumer_order";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_id", nullable = false)
    private Long orderId;

    @Column(name = ENTITY_PREFIX + "_title", nullable = false)
    private String orderTitle;

    @Column(name = ENTITY_PREFIX + "_seller", nullable = false)
    private String seller;

    @Column(name = ENTITY_PREFIX + "_script", nullable = false)
    private String script;

    @Column(name = ENTITY_PREFIX + "_price", nullable = false)
    private Long price;

    @Column(name = ENTITY_PREFIX + "_imageURL", nullable = false)
    private String imageUrl;

    @Column(name = ENTITY_PREFIX + "_category", nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

}
