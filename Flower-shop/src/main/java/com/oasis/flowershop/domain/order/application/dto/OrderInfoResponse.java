package com.oasis.flowershop.domain.order.application.dto;


import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class OrderInfoResponse {

    private Long id;
    private String title;
    private String name;
    private Long price;
    private String imageURL;
    private String script;
    private String category;

}
