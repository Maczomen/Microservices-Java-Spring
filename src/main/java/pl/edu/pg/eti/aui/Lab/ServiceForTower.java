package pl.edu.pg.eti.aui.Lab;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceForTower {
    private final RepositoryForTower repository;


    public Optional<Tower> find(String name) {
        return repository.find(name);
    }

    public List<Tower> findAll() {
        return repository.findAll();
    }

    public void create(Tower entity) {
        repository.create(entity);
    }

    public void delete(Tower entity) {
        repository.delete(entity);
    }
}
