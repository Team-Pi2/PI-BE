package com.oasis.flowershop.domain.chat.application.usecase;

import com.oasis.flowershop.domain.chat.application.model.ChatRoomModel;

import java.util.List;

public interface ChatGetUseCase {

    List<ChatRoomModel> findAll();

    List<ChatRoomModel> findByKeyword(String keyword);

    ChatRoomModel findOne(Long chatId);


}
