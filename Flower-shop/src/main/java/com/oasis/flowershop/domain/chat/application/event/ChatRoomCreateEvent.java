package com.oasis.flowershop.domain.chat.application.event;

import lombok.Getter;

import java.util.List;

@Getter
public class ChatRoomCreateEvent {

    private Long chatId;
    private List<String> tags;

    private ChatRoomCreateEvent(Long chatId, List<String> tags){
        this.chatId = chatId;
        this.tags = tags;
    }

    public static ChatRoomCreateEvent of(Long chatId, List<String> tags){
        return new ChatRoomCreateEvent(chatId, tags);
    }

}
