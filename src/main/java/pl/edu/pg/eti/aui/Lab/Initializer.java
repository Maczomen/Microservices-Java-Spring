package pl.edu.pg.eti.aui.Lab;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class Initializer {

    private final ServiceForTower serviceForTower;
    private final ServiceForTowerType serviceForTowerType;


    @PostConstruct
    private void init(){
        if(serviceForTowerType.find("Hellfire").isEmpty()){
            TowerType hellfire = TowerType.builder()
                    .name("Hellfire")
                    .bonusStrength(15)
                    .bonusName("attack_speed")
                    .build();

            TowerType frost_hell = TowerType.builder()
                    .name("Frost hell")
                    .bonusStrength(4)
                    .bonusName("slow")
                    .build();

            serviceForTowerType.create(hellfire);
            serviceForTowerType.create(frost_hell);


            Tower archer = Tower.builder()
                    .name("Archer")
                    .range(100)
                    .attackSpeed(10)
                    .type(frost_hell)
                    .cost(100)
                    .damage(3)
                    .build();

            Tower cannon = Tower.builder()
                    .name("Cannon")
                    .range(50)
                    .attackSpeed(5)
                    .type(hellfire)
                    .cost(300)
                    .damage(20)
                    .build();

            Tower mage = Tower.builder()
                    .name("Mage")
                    .range(200)
                    .attackSpeed(6)
                    .type(frost_hell)
                    .cost(150)
                    .damage(5)
                    .build();

            serviceForTower.create(archer);
            serviceForTower.create(cannon);
            serviceForTower.create(mage);
        }

    }
}
