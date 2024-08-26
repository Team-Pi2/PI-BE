package com.oasis.flowershop.domain.shop.persistence;

import com.oasis.flowershop.common.persistence.BaseEntity;
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
@Table(
        name = ShopEntity.ENTITY_PREFIX)
@SQLDelete(sql = "UPDATE shop SET is_deleted=true where shop_id=?")
// delete from program where program_id=1;
@Where(clause = "is_deleted=false")
public class ShopEntity extends BaseEntity {

    public static final String ENTITY_PREFIX = "shop";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_id", nullable = false)
    private Long shopId;

    @Column(name = ENTITY_PREFIX + "_name", nullable = false)
    private String shopName;

    @Column(name = ENTITY_PREFIX + "_corporation_certnumber", nullable = false)
    private String certNumber;

}
