package com.oasis.flowershop.domain.plant.application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class PlantModel {

    private Long plantId;
    private String name;
    private Long age;
    private String water;
    private String env;

}
