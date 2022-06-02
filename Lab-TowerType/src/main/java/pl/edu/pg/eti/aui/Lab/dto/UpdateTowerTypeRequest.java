package pl.edu.pg.eti.aui.Lab.dto;

import lombok.*;
import pl.edu.pg.eti.aui.Lab.entities.TowerType;

import java.util.function.BiFunction;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class UpdateTowerTypeRequest {

    private String bonusName;

    private int bonusStrength;

    public static BiFunction<TowerType, UpdateTowerTypeRequest, TowerType> dtoToEntityUpdater() {
        return (towerType, request) -> {
            towerType.setBonusName(request.getBonusName());
            towerType.setBonusStrength(request.getBonusStrength());
            return towerType;
        };
    }
}
