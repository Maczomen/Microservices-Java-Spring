package pl.edu.pg.eti.aui.Lab;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.edu.pg.eti.aui.Lab.entities.TowerType;
import pl.edu.pg.eti.aui.Lab.services.ServiceForTowerType;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class Initializer {

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
        }

    }
}
