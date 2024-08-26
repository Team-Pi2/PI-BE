package com.oasis.flowershop.domain.plant.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PlantResponse {

    private Long id;
    private String name;
    private String water;
    private String env;
    private Long age;

}
