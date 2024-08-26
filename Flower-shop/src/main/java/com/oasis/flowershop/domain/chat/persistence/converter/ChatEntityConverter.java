package com.oasis.flowershop.domain.chat.persistence.converter;

import com.oasis.flowershop.domain.chat.application.dto.CreateChatRoomRequest;
import com.oasis.flowershop.domain.chat.persistence.ChatEntity;
import org.springframework.stereotype.Component;

@Component
public class ChatEntityConverter {

    public ChatEntity toEntity(CreateChatRoomRequest request){
        return ChatEntity.builder()
                .title(request.getTitle())
                .imageURL(request.getImage())
                .build();
    }

}
