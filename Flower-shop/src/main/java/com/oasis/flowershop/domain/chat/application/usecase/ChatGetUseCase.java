package com.oasis.flowershop.domain.chat.application.usecase;

import com.oasis.flowershop.domain.chat.application.model.ChatModel;

import java.util.List;

public interface ChatGetUseCase {

    List<ChatModel> findAll();

}
