package com.oasis.flowershop.domain.plant.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PlantsResponse {

    private List<PlantResponse> plantInfos;

}
