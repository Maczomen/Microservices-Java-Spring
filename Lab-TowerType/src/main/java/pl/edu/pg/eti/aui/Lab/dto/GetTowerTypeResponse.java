package pl.edu.pg.eti.aui.Lab.dto;

import lombok.*;
import pl.edu.pg.eti.aui.Lab.entities.TowerType;

import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetTowerTypeResponse {

    private String name;

    private String bonusName;

    private int bonusStrength;

    public static Function<TowerType, GetTowerTypeResponse> entityToDtoMapper() {
        return tower -> GetTowerTypeResponse.builder()
                .name(tower.getName())
                .bonusName(tower.getBonusName())
                .bonusStrength(tower.getBonusStrength())
                .build();
    }
}
