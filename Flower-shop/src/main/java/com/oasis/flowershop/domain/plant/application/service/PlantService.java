package com.oasis.flowershop.domain.plant.application.service;

import com.oasis.flowershop.domain.plant.application.dto.PlantCreateRequest;
import com.oasis.flowershop.domain.plant.application.exception.NotFoundPlantException;
import com.oasis.flowershop.domain.plant.application.model.PlantModel;
import com.oasis.flowershop.domain.plant.application.model.converter.PlantModelConverter;
import com.oasis.flowershop.domain.plant.application.usecase.PlantCreateUseCase;
import com.oasis.flowershop.domain.plant.application.usecase.PlantGetUseCase;
import com.oasis.flowershop.domain.plant.persistence.PlantEntity;
import com.oasis.flowershop.domain.plant.persistence.PlantRepository;
import com.oasis.flowershop.domain.plant.persistence.converter.PlantEntityConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlantService
        implements PlantGetUseCase,
        PlantCreateUseCase {

    private final PlantRepository plantRepository;
    private final PlantModelConverter plantModelConverter;
    private final PlantEntityConverter plantEntityConverter;

    @Override
    public List<PlantModel> search() {
        return findAll();
    }

    @Override
    public List<PlantModel> search(String keyword){
        return findAll().stream()
                .filter(model -> model.getName().contains(keyword))
                .toList();
    }

    @Override
    public Long register(PlantCreateRequest request) {
        PlantEntity entity = plantEntityConverter.from(request);
        return plantRepository.save(entity).getPlantId();
    }

    @Override
    public PlantModel findOne(Long plantId) {
        return plantRepository.findOne(plantId)
                .map(plantModelConverter::from)
                .orElseThrow(NotFoundPlantException::new);
    }

    private List<PlantModel> findAll(){
        return plantRepository.findAll().stream()
                .map(plantModelConverter::from)
                .toList();
    }

}
