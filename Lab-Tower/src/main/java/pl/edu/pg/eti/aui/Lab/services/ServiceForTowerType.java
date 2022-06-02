package pl.edu.pg.eti.aui.Lab.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.pg.eti.aui.Lab.entities.TowerType;
import pl.edu.pg.eti.aui.Lab.repositories.RepositoryForTowerType;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceForTowerType {
    private final RepositoryForTowerType repository;


    public Optional<TowerType> find(String name) {
        return repository.findById(name);
    }

    public void create(TowerType entity) {
        repository.save(entity);
    }

    public void delete(TowerType entity) {
        repository.delete(entity);
    }
}
