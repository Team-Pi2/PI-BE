package com.oasis.flowershop.domain.plant.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlantRepository extends JpaRepository<PlantEntity, Long> {

    List<PlantEntity> findAll();

    @Query("SELECT p FROM PlantEntity p WHERE p.plantId=:plantId")
    Optional<PlantEntity> findOne(@Param("plantId") Long plantId);

}
