package pl.edu.pg.eti.aui.Lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pg.eti.aui.Lab.entities.TowerType;

@Repository
public interface RepositoryForTowerType extends JpaRepository<TowerType, String> {

}