package com.oasis.flowershop.domain.plant.application.model.converter;

import com.oasis.flowershop.domain.plant.application.model.PlantModel;
import com.oasis.flowershop.domain.plant.persistence.PlantEntity;
import org.springframework.stereotype.Component;

@Component
public class PlantModelConverter {

    public PlantModel from(PlantEntity source){
        return PlantModel.builder()
                .plantId(source.getPlantId())
                .age(source.getAge())
                .env(source.getEnv())
                .name(source.getName())
                .water(source.getWater())
                .build();
    }

}
