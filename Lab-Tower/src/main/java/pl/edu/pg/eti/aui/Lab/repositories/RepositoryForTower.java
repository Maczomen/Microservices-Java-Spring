package pl.edu.pg.eti.aui.Lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pg.eti.aui.Lab.entities.Tower;
import pl.edu.pg.eti.aui.Lab.entities.TowerType;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryForTower extends JpaRepository<Tower, String> {

    List<Tower> findAllByTowerType(TowerType towerType);

    Optional<Tower> findByNameAndTowerType(String name, TowerType towerType);
}
