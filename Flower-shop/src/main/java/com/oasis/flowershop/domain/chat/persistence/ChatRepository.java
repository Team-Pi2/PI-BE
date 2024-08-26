package com.oasis.flowershop.domain.chat.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChatRepository extends JpaRepository<ChatEntity, Long> {

    List<ChatEntity> findAll();

    @Query("SELECT c FROM ChatEntity c WHERE c.chatId=:chatId")
    Optional<ChatEntity> findById(@Param("chatId") Long chatId);

}
