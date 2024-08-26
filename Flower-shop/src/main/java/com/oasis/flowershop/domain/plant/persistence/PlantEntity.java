package com.oasis.flowershop.domain.plant.persistence;

import com.oasis.flowershop.common.persistence.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@SuperBuilder(toBuilder = true)
@Entity
@Table(
        name = PlantEntity.ENTITY_PREFIX
)
@SQLDelete(sql = "UPDATE plant SET is_deleted=true where plant_id=?")
// delete from program where program_id=1;
@Where(clause = "is_deleted=false")
public class PlantEntity extends BaseEntity {

    public static final String ENTITY_PREFIX = "plant";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_id", nullable = false)
    private Long plantId;

    @Column(name = ENTITY_PREFIX + "_name", nullable = false)
    private String name;

    @Column(name = ENTITY_PREFIX + "_age", nullable = false)
    private Long age;

    @Column(name = ENTITY_PREFIX + "water", nullable = false)
    private String water;

    @Column(name = ENTITY_PREFIX + "env", nullable = false)
    private String env;

}
