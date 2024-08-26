package com.oasis.flowershop.domain.chat.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TagRepository extends JpaRepository<TagEntity, Long> {

    @Query("SELECT t.tagName FROM TagEntity t WHERE t.chatId=:chatId")
    List<String> findsByRoomId(@Param("chatId") Long chatId);

}
