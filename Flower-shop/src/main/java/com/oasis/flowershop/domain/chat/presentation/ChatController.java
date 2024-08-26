package com.oasis.flowershop.domain.chat.presentation;

import com.oasis.flowershop.common.presentation.response.ApiResponse;
import com.oasis.flowershop.common.presentation.response.ApiResponseBody.*;
import com.oasis.flowershop.common.presentation.response.ApiResponseGenerator;
import com.oasis.flowershop.common.presentation.response.MessageCode;
import com.oasis.flowershop.domain.chat.application.dto.ChatRoomResponse;
import com.oasis.flowershop.domain.chat.application.dto.ChatRoomsResponse;
import com.oasis.flowershop.domain.chat.application.dto.CreateChatRoomRequest;
import com.oasis.flowershop.domain.chat.application.dto.converter.ChatResponseConverter;
import com.oasis.flowershop.domain.chat.application.model.ChatRoomModel;
import com.oasis.flowershop.domain.chat.application.service.ChatService;
import com.oasis.flowershop.domain.chat.application.usecase.ChatCreateUseCase;
import com.oasis.flowershop.domain.chat.application.usecase.ChatGetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chats")
public class ChatController {

    private final ChatGetUseCase chatGetUseCase;
    private final ChatCreateUseCase chatCreateUseCase;
    private final ChatResponseConverter responseConverter;
    private final ChatService chatService;

    @GetMapping
    public ApiResponse<SuccessBody<ChatRoomsResponse>> searchRooms(
            @RequestParam("keyword") String keyword
    ){
        List<ChatRoomModel> models;

        if(keyword.equals("all")) models = chatGetUseCase.findAll();
        else models = chatGetUseCase.findByKeyword(keyword);

        List<ChatRoomResponse> responses = models.stream()
                .map(responseConverter::from)
                .toList();

        return ApiResponseGenerator.success(new ChatRoomsResponse(responses),
                HttpStatus.OK,
                MessageCode.GET
        );
    }

    @PostMapping
    public ApiResponse<SuccessBody<ChatRoomResponse>> createChatRooms(
            @RequestBody CreateChatRoomRequest request){
        Long savedId = chatCreateUseCase.createChatRoom(request);
        ChatRoomResponse response = responseConverter.from(chatGetUseCase.findOne(savedId));

        return ApiResponseGenerator.success(response, HttpStatus.OK, MessageCode.CREATE);
    }

    @PostMapping("/{chatId}/members")
    public ApiResponse<SuccessBody<Void>> createMember(@PathVariable("chatId") Long chatId){
        chatService.createMember(chatId);
        return ApiResponseGenerator.success(HttpStatus.OK, MessageCode.CREATE);
    }

}
