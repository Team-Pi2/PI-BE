package com.oasis.flowershop.domain.plant.persistence.converter;

import com.oasis.flowershop.domain.plant.application.dto.PlantCreateRequest;
import com.oasis.flowershop.domain.plant.persistence.PlantEntity;
import org.springframework.stereotype.Component;

@Component
public class PlantEntityConverter {

    public PlantEntity from(PlantCreateRequest request){
        return PlantEntity.builder()
                .name(request.getName())
                .age(request.getAge())
                .env(request.getEnv())
                .water(request.getWater())
                .build();
    }

}
