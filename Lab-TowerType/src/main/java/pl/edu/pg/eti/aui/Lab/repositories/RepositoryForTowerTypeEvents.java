package pl.edu.pg.eti.aui.Lab.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.edu.pg.eti.aui.Lab.dto.CreateTowerTypeEventRequest;
import pl.edu.pg.eti.aui.Lab.entities.TowerType;

@Repository
public class RepositoryForTowerTypeEvents {

    private final RestTemplate restTemplate;

    @Autowired
    public RepositoryForTowerTypeEvents(@Value("${tower.url}") String baseUrl) {
        restTemplate = new RestTemplateBuilder().rootUri(baseUrl).build();
    }

    public void delete(TowerType towerType) {
        restTemplate.delete("/towerTypes/{username}", towerType.getName());
    }

    public void create(TowerType towerType) {
        restTemplate.postForLocation("/towerTypes", CreateTowerTypeEventRequest.entityToDtoMapper().apply(towerType));
    }

}
