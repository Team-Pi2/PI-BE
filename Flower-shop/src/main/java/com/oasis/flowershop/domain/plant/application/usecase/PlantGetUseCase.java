package com.oasis.flowershop.domain.plant.application.usecase;

import com.oasis.flowershop.domain.plant.application.model.PlantModel;

import java.util.List;

public interface PlantGetUseCase {

    List<PlantModel> search();

    List<PlantModel> search(String keyword);

    PlantModel findOne(Long plantId);

}
