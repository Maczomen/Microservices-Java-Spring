package pl.edu.pg.eti.aui.Lab.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.pg.eti.aui.Lab.entities.TowerType;
import pl.edu.pg.eti.aui.Lab.repositories.RepositoryForTowerType;
import pl.edu.pg.eti.aui.Lab.repositories.RepositoryForTowerTypeEvents;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceForTowerType {
    private final RepositoryForTowerType repository;
    private final RepositoryForTowerTypeEvents repositoryEvent;


    public Optional<TowerType> find(String name) {
        return repository.findById(name);
    }

    public List<TowerType> findAll() {
        return repository.findAll();
    }

    public void create(TowerType entity) {
        repositoryEvent.create(entity);
        repository.save(entity);
    }

    public void update(TowerType entity) {
        repository.save(entity);
    }

    public void delete(TowerType entity) {
        repositoryEvent.delete(entity);
        repository.delete(entity);
    }
}
