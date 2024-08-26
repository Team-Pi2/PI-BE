package com.oasis.flowershop.domain.chat.application.dto.converter;

import com.oasis.flowershop.domain.chat.application.dto.ChatRoomResponse;
import com.oasis.flowershop.domain.chat.application.model.ChatRoomModel;
import com.oasis.flowershop.domain.chat.persistence.RoomRepository;
import com.oasis.flowershop.domain.chat.persistence.TagRepository;
import com.oasis.flowershop.domain.order.application.model.OrderModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChatResponseConverter {

    private final RoomRepository roomRepository;
    private final TagRepository tagRepository;

    public ChatRoomResponse from(ChatRoomModel source){
        return ChatRoomResponse.builder()
                .id(source.getChatRoomId())
                .title(source.getTitle())
                .tags(source.getTags())
                .member(source.getMember())
                .imageURL(source.getImageURL())
                .build();
    }

    public ChatRoomResponse from(OrderModel order){
        return ChatRoomResponse.builder()
                .id(order.getOrderId())
                .title(order.getOrderTitle())
                .tags(tagRepository.findsByRoomId(order.getOrderId()))
                .member(roomRepository.countByRoomId(order.getOrderId()))
                .imageURL(order.getImageURL())
                .build();
    }

//    private Long count(Long chatId){
//        return roomRepository.countByRoomId(chatId).stream().count();
//    }
}
