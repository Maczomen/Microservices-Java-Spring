package pl.edu.pg.eti.aui.Lab.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.edu.pg.eti.aui.Lab.dto.*;
import pl.edu.pg.eti.aui.Lab.entities.TowerType;
import pl.edu.pg.eti.aui.Lab.services.ServiceForTowerType;

import java.util.Optional;

@RestController
@RequestMapping("api/towerTypes")
@AllArgsConstructor
public class ControllerForTowerType {

    private final ServiceForTowerType serviceForTowerType;


    @PostMapping
    public ResponseEntity<Void> createTowerType(@RequestBody CreateTowerTypeRequest request, UriComponentsBuilder builder){
        TowerType towerType = CreateTowerTypeRequest
                .dtoToEntityMapper()
                .apply(request);
        serviceForTowerType.create(towerType);
        return ResponseEntity.created(builder.pathSegment("api", "towerTypes", "{name}")
                .buildAndExpand(towerType.getName()).toUri()).build();
    }

    @DeleteMapping("{name}")
    public ResponseEntity<Void> deleteTowerType(@PathVariable("name") String name){
        Optional<TowerType> towerType = serviceForTowerType.find(name);
        if(towerType.isPresent()){
            serviceForTowerType.delete(towerType.get());
            return ResponseEntity.accepted().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
