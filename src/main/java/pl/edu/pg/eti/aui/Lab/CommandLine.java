package pl.edu.pg.eti.aui.Lab;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
@AllArgsConstructor
public class CommandLine implements CommandLineRunner {

    private final ServiceForTower serviceForTower;
    private final ServiceForTowerType serviceForTowerType;


    @Override
    public void run(String... args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;

        do {
            command = reader.readLine();
            switch (command){
                case "at":
                    System.out.println("Name of new tower:");
                    String name = reader.readLine();

                    System.out.println("Range of new tower:");
                    int range = Integer.parseInt(reader.readLine());

                    System.out.println("Attack speed of new tower:");
                    int attack_speed = Integer.parseInt(reader.readLine());

                    System.out.println("Type of new tower:");
                    serviceForTowerType.findAll().forEach(System.out::println);
                    String type = reader.readLine();
                    while( serviceForTowerType.find(type).isEmpty()){
                        System.out.println("This tower type doesn't exist try one of the following:");
                        serviceForTowerType.findAll().forEach(System.out::println);
                        type = reader.readLine();
                    }
                    TowerType tower_type =  serviceForTowerType.find(type).stream().findFirst().get();

                    System.out.println("Cost of new tower:");
                    int cost = Integer.parseInt(reader.readLine());

                    System.out.println("Damage of new tower:");
                    int damage = Integer.parseInt(reader.readLine());

                    Tower tower = Tower.builder()
                            .name(name)
                            .range(range)
                            .attackSpeed(attack_speed)
                            .type(tower_type)
                            .cost(cost)
                            .damage(damage)
                            .build();
                    serviceForTower.create(tower);
                    break;
                case "dt":
                    System.out.println("Name of tower to delete:");
                    name = reader.readLine();
                    serviceForTower.find(name).ifPresent(
                            serviceForTower::delete
                    );

                    break;
                case "t":
                    serviceForTower.findAll().forEach(System.out::println);
                    break;
                case "st":
                    System.out.println("Name of tower you seek:");
                    name = reader.readLine();
                    if(serviceForTower.find(name).isPresent()){
                        System.out.println(serviceForTower.find(name));
                    }
                    break;
                case "ate":
                    System.out.println("Name of new tower:");
                    name = reader.readLine();

                    System.out.println("Range of new tower:");
                    String bonus_name = reader.readLine();

                    System.out.println("Attack speed of new tower:");
                    int bonus_strength = Integer.parseInt(reader.readLine());

                    TowerType tower_evo = TowerType.builder()
                            .name(name)
                            .bonusName(bonus_name)
                            .bonusStrength(bonus_strength)
                            .build();
                    serviceForTowerType.create(tower_evo);
                    break;
                case "dte":
                    System.out.println("Name of tower type to delete:");
                    name = reader.readLine();
                    if(serviceForTowerType.find(name).isPresent())
                        serviceForTowerType.delete(serviceForTowerType.find(name).get());
                    break;
                case "te":
                    serviceForTowerType.findAll().forEach(System.out::println);
                    break;
                case "ste":
                    System.out.println("Name of tower type you seek:");
                    name = reader.readLine();
                    if(serviceForTowerType.find(name).isPresent()){
                        System.out.println(serviceForTowerType.find(name));
                    }
                    break;
                default:
                    System.out.println(
                            "help - shows available commands \n" +
                                    "at - add tower\n" +
                                    "dt -delete tower\n" +
                                    "t - show all towers\n" +
                                    "st - show specific tower\n" +
                                    "ate - add tower type\n" +
                                    "dte -delete tower type\n" +
                                    "te - show all tower types\n" +
                                    "ste - show specific tower type\n" +
                                    "X - to exit program");
            }

        } while (!command.equals("X"));


    }

}
