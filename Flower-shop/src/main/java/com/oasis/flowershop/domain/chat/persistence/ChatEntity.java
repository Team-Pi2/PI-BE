package com.oasis.flowershop.domain.chat.persistence;

import com.oasis.flowershop.domain.order.persistence.OrderEntity;
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
@Table(name = ChatEntity.ENTITY_PREFIX)
@SQLDelete(sql = "UPDATE chat SET is_deleted=true where chat_id=?")
@Where(clause = "is_deleted=false")
public class ChatEntity {

    public static final String ENTITY_PREFIX = "chat";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_id", nullable = false)
    private Long chatId;

    @Column(name = ENTITY_PREFIX + "_order_id", nullable = false)
    private Long orderId;

}
