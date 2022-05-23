package pl.edu.pg.eti.aui.Lab;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Storage {

    private final Set<Tower> towers = new HashSet<>();
    private final Set<TowerType> towerTypes = new HashSet<>();


    public Optional<Tower> findTower(String name) {
        return towers
                .stream()
                .filter(towers -> towers.getName().equals(name))
                .findFirst();
    }

    public List<Tower> findAllTowers() {
        return new ArrayList<>(towers);
    }

    public void createTower(Tower entity) {
        if(findTower(entity.getName()).isEmpty()){
            towers.add(entity);
        }
    }

    public void deleteTower(String name) {
        findTower(name).ifPresent(
                towers::remove
        );
    }


    public Optional<TowerType> findTowerEvolution(String name) {
        return towerTypes
                .stream()
                .filter(tower_evolutions -> tower_evolutions.getName().equals(name))
                .findFirst();
    }

    public List<TowerType> findAllTowerEvolutions() {
        return new ArrayList<>(towerTypes);
    }

    public void createTowerEvolution(TowerType entity) {
        if(findTowerEvolution(entity.getName()).isEmpty()){
            towerTypes.add(entity);
        }
    }

    public void deleteTowerEvolution(String name) {
        findTowerEvolution(name).ifPresent(
                towerTypes::remove
        );
    }
}
