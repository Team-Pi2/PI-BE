package com.oasis.flowershop.domain.chat.presentation;

import com.oasis.flowershop.common.presentation.response.ApiResponse;
import com.oasis.flowershop.common.presentation.response.ApiResponseBody.*;
import com.oasis.flowershop.domain.chat.application.dto.ChatRoomsResponse;
import com.oasis.flowershop.domain.chat.application.usecase.ChatGetUseCase;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chats")
public class ChatController {

    private final ChatGetUseCase chatGetUseCase;

    @GetMapping
    public ApiResponse<SuccessBody<ChatRoomsResponse>> findChatRooms(){
        
    }

}
