package pl.edu.pg.eti.aui.Lab.dto;

import lombok.*;
import pl.edu.pg.eti.aui.Lab.entities.Tower;

import java.util.function.BiFunction;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class UpdateTowerRequest {

    private int range;

    private int attackSpeed;

    private int cost;

    private int damage;

    public static BiFunction<Tower, UpdateTowerRequest, Tower> dtoToEntityUpdater() {
        return (tower, request) -> {
            tower.setRange(request.getRange());
            tower.setAttackSpeed(request.getAttackSpeed());
            tower.setCost(request.getCost());
            tower.setDamage(request.getDamage());
            return tower;
        };
    }
}
