package com.oasis.flowershop.domain.chat.persistence;

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
@Table(name = RoomEntity.ENTITY_PREFIX)
@SQLDelete(sql = "UPDATE room SET is_deleted=true where room_id=?")
@Where(clause = "is_deleted=false")
public class RoomEntity extends BaseEntity {

    public static final String ENTITY_PREFIX = "room";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_id", nullable = false)
    private Long roomId;

    @Column(name = ENTITY_PREFIX + "_chat_id", nullable = false)
    private Long chatId;

    @Column(name = ENTITY_PREFIX + "_member_id", nullable = false)
    private Long memberId;

}
