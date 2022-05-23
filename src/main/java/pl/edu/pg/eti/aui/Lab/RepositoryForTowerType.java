package pl.edu.pg.eti.aui.Lab;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class RepositoryForTowerType {

    private final Storage storage;


    public Optional<TowerType> find(String name) {
        return storage.findTowerEvolution(name);
    }

    public List<TowerType> findAll() {
        return storage.findAllTowerEvolutions();
    }

    public void create(TowerType entity) {
        storage.createTowerEvolution(entity);
    }

    public void delete(TowerType entity) {
        storage.deleteTowerEvolution(entity.getName());
    }
}