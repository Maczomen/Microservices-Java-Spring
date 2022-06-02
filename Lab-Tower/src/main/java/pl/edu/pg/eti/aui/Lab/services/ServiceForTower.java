package pl.edu.pg.eti.aui.Lab.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.pg.eti.aui.Lab.entities.Tower;
import pl.edu.pg.eti.aui.Lab.entities.TowerType;
import pl.edu.pg.eti.aui.Lab.repositories.RepositoryForTower;
import pl.edu.pg.eti.aui.Lab.repositories.RepositoryForTowerType;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceForTower {
    private final RepositoryForTower repositoryForTower;
    private final RepositoryForTowerType repositoryForTowerType;


    public Optional<Tower> find(String name) {
        return repositoryForTower.findById(name);
    }

    public Optional<Tower> find(String name, String towerTypeName) {
        Optional<TowerType> towerType = repositoryForTowerType.findById(towerTypeName);
        if(towerType.isPresent()){
            return repositoryForTower.findByNameAndTowerType(name, towerType.get());
        } else {
            return Optional.empty();
        }
    }

    public List<Tower> findAll() {
        return repositoryForTower.findAll();
    }

    public List<Tower> findAll(TowerType towerType) { return repositoryForTower.findAllByTowerType(towerType);}

    public void create(Tower entity) {
        repositoryForTower.save(entity);
    }

    public void update(Tower entity) {
        repositoryForTower.save(entity);
    }

    public void delete(Tower entity) {
        repositoryForTower.delete(entity);
    }
}
