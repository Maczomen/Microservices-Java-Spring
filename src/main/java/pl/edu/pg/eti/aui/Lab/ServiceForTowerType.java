package pl.edu.pg.eti.aui.Lab;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceForTowerType {
    private final RepositoryForTowerType repository;


    public Optional<TowerType> find(String name) {
        return repository.find(name);
    }

    public List<TowerType> findAll() {
        return repository.findAll();
    }

    public void create(TowerType entity) {
        repository.create(entity);
    }

    public void delete(TowerType entity) {
        repository.delete(entity);
    }
}
