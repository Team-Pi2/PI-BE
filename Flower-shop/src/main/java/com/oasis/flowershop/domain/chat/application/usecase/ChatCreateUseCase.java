package com.oasis.flowershop.domain.chat.application.usecase;

import com.oasis.flowershop.domain.chat.application.dto.CreateChatRoomRequest;

public interface ChatCreateUseCase {

    Long createChatRoom(CreateChatRoomRequest request);

}
