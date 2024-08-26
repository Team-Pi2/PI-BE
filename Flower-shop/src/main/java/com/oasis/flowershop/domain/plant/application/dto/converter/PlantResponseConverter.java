package com.oasis.flowershop.domain.plant.application.dto.converter;

import com.oasis.flowershop.domain.plant.application.dto.PlantResponse;
import com.oasis.flowershop.domain.plant.application.model.PlantModel;
import org.springframework.stereotype.Component;

@Component
public class PlantResponseConverter {

    public PlantResponse from(PlantModel source){
        return PlantResponse.builder()
                .age(source.getAge())
                .id(source.getPlantId())
                .env(source.getEnv())
                .name(source.getName())
                .water(source.getWater())
                .build();
    }

}
