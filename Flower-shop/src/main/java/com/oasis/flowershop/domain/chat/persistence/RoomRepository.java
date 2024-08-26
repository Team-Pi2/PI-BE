package com.oasis.flowershop.domain.chat.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

    @Query("SELECT COUNT(r) FROM RoomEntity r WHERE r.chatId=:chatId")
    Long countByRoomId(@Param("chatId") Long chatId);

}
