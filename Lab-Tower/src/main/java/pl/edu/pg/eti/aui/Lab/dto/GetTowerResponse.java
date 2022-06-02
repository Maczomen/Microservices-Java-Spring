package pl.edu.pg.eti.aui.Lab.dto;

import lombok.*;
import pl.edu.pg.eti.aui.Lab.entities.Tower;

import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetTowerResponse {

    private String name;

    private int range;

    private int attackSpeed;

    private String towerType;

    private int cost;

    private int damage;

    public static Function<Tower, GetTowerResponse> entityToDtoMapper() {
        return tower -> GetTowerResponse.builder()
                .name(tower.getName())
                .range(tower.getRange())
                .attackSpeed(tower.getAttackSpeed())
                .towerType(tower.getTowerType().getName())
                .cost(tower.getCost())
                .damage(tower.getDamage())
                .build();
    }
}
