package com.oasis.flowershop.domain.plant.application.usecase;

import com.oasis.flowershop.domain.plant.application.dto.PlantCreateRequest;

public interface PlantCreateUseCase {

    Long register(PlantCreateRequest request);

}
