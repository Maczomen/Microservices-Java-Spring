package pl.edu.pg.eti.aui.Lab;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.edu.pg.eti.aui.Lab.entities.Tower;
import pl.edu.pg.eti.aui.Lab.entities.TowerType;
import pl.edu.pg.eti.aui.Lab.services.ServiceForTower;
import pl.edu.pg.eti.aui.Lab.services.ServiceForTowerType;

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
                    .build();

            TowerType frost_hell = TowerType.builder()
                    .name("Frost hell")
                    .build();

            serviceForTowerType.create(hellfire);
            serviceForTowerType.create(frost_hell);


            Tower archer = Tower.builder()
                    .name("Archer")
                    .range(100)
                    .attackSpeed(10)
                    .towerType(frost_hell)
                    .cost(100)
                    .damage(3)
                    .build();

            Tower cannon = Tower.builder()
                    .name("Cannon")
                    .range(50)
                    .attackSpeed(5)
                    .towerType(hellfire)
                    .cost(300)
                    .damage(20)
                    .build();

            Tower mage = Tower.builder()
                    .name("Mage")
                    .range(200)
                    .attackSpeed(6)
                    .towerType(frost_hell)
                    .cost(150)
                    .damage(5)
                    .build();

            serviceForTower.create(archer);
            serviceForTower.create(cannon);
            serviceForTower.create(mage);
        }

    }
}
