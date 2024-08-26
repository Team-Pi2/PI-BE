package com.oasis.flowershop.domain.chat.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class CreateChatRoomRequest {

    private String title;
    private String image;
    private List<String> tags;

}
