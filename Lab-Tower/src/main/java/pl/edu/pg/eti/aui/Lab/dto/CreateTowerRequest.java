package pl.edu.pg.eti.aui.Lab.dto;

import lombok.*;
import pl.edu.pg.eti.aui.Lab.entities.Tower;
import pl.edu.pg.eti.aui.Lab.entities.TowerType;

import java.util.function.Function;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class CreateTowerRequest {
    private String name;

    private int range;

    private int attackSpeed;

    private String towerType;

    private int cost;

    private int damage;

    public static Function<CreateTowerRequest, Tower> dtoToEntityMapper(Function<String, TowerType> towerTypeFunction) {
        return request -> Tower.builder()
                .name(request.getName())
                .range(request.getRange())
                .attackSpeed(request.getAttackSpeed())
                .towerType(towerTypeFunction.apply(request.getTowerType()))
                .cost(request.getCost())
                .damage(request.getDamage())
                .build();
    }
}
