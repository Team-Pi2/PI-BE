package com.oasis.flowershop.domain.chat.application.model.converter;

import com.oasis.flowershop.domain.chat.application.model.ChatRoomModel;
import com.oasis.flowershop.domain.chat.persistence.ChatEntity;
import com.oasis.flowershop.domain.chat.persistence.RoomEntity;
import com.oasis.flowershop.domain.chat.persistence.RoomRepository;
import com.oasis.flowershop.domain.chat.persistence.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChatRoomModelConverter {

    private final TagRepository tagRepository;
    private final RoomRepository roomRepository;

    public ChatRoomModel from(ChatEntity entity){
        return ChatRoomModel.builder()
                .chatRoomId(entity.getChatId())
                .title(entity.getTitle())
                .tags(tagRepository.findsByRoomId(entity.getChatId()))
                .member(roomRepository.countByRoomId(entity.getChatId()))
                .imageURL(entity.getImageURL())
                .build();
    }
//
//    private Long count(Long chatId){
//        return roomRepository.countByRoomId(chatId).stream().count();
//    }

}
