package pl.edu.pg.eti.aui.Lab;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class RepositoryForTower {

    private final Storage storage;


    public Optional<Tower> find(String name) {
        return storage.findTower(name);
    }

    public List<Tower> findAll() {
        return storage.findAllTowers();
    }

    public void create(Tower entity) {
        storage.createTower(entity);
    }

    public void delete(Tower entity) {
        storage.deleteTower(entity.getName());
    }
}
