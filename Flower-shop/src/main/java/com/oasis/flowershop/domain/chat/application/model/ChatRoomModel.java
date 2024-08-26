package com.oasis.flowershop.domain.chat.application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ChatRoomModel {

    private Long chatRoomId;
    private Long member;
    private String title;
    private List<String> tags;
    private String imageURL;

}
