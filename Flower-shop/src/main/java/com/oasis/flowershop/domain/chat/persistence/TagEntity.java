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
@Table(name = TagEntity.ENTITY_PREFIX)
@SQLDelete(sql = "UPDATE tag SET is_deleted=true where tag_id=?")
@Where(clause = "is_deleted=false")
public class TagEntity extends BaseEntity {

    public static final String ENTITY_PREFIX = "tag";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_id", nullable = false)
    private Long tagId;

    @Column(name = ENTITY_PREFIX + "_chat_id", nullable = false)
    private Long chatId;

    @Column(name = ENTITY_PREFIX + "_name", nullable = false)
    private String tagName;

    public static TagEntity of(Long chatId, String tagName){
        return TagEntity.builder().chatId(chatId).tagName(tagName).build();
    }
}
