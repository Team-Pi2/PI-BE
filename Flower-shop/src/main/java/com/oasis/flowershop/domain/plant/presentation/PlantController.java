package com.oasis.flowershop.domain.plant.presentation;

import com.oasis.flowershop.common.presentation.response.ApiResponse;
import com.oasis.flowershop.common.presentation.response.ApiResponseBody.*;
import com.oasis.flowershop.common.presentation.response.ApiResponseGenerator;
import com.oasis.flowershop.common.presentation.response.MessageCode;
import com.oasis.flowershop.domain.plant.application.dto.PlantCreateRequest;
import com.oasis.flowershop.domain.plant.application.dto.PlantResponse;
import com.oasis.flowershop.domain.plant.application.dto.PlantsResponse;
import com.oasis.flowershop.domain.plant.application.dto.converter.PlantResponseConverter;
import com.oasis.flowershop.domain.plant.application.model.PlantModel;
import com.oasis.flowershop.domain.plant.application.usecase.PlantCreateUseCase;
import com.oasis.flowershop.domain.plant.application.usecase.PlantGetUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/plants")
@Slf4j
public class PlantController {

    private final PlantCreateUseCase plantCreateUseCase;
    private final PlantGetUseCase plantGetUseCase;
    private final PlantResponseConverter plantResponseConverter;

    @GetMapping
    public ApiResponse<SuccessBody<PlantsResponse>> search(
            @RequestParam("keyword") String keyword
    ){
        log.info("키워드 : "+keyword);
        List<PlantModel> models = plantGetUseCase.search(keyword);
        PlantsResponse response = new PlantsResponse(models.stream()
                .map(plantResponseConverter::from)
                .toList());

        return ApiResponseGenerator.success(response, HttpStatus.OK, MessageCode.GET);
    }

    @PostMapping
    public ApiResponse<SuccessBody<PlantResponse>> register(
            @RequestBody PlantCreateRequest request
            ){
        Long savedId = plantCreateUseCase.register(request);
        PlantResponse response = plantResponseConverter.from(plantGetUseCase.findOne(savedId));
        return ApiResponseGenerator.success(response, HttpStatus.OK, MessageCode.CREATE);
    }

}