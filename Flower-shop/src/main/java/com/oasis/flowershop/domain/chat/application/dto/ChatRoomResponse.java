package com.oasis.flowershop.domain.chat.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ChatRoomResponse {

    private Long id;
    private String title;
    private Long member;
    private List<String> tags;
    private String imageURL;

}
