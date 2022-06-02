package pl.edu.pg.eti.aui.Lab.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.edu.pg.eti.aui.Lab.dto.CreateTowerRequest;
import pl.edu.pg.eti.aui.Lab.dto.GetTowerResponse;
import pl.edu.pg.eti.aui.Lab.dto.GetTowersResponse;
import pl.edu.pg.eti.aui.Lab.dto.UpdateTowerRequest;
import pl.edu.pg.eti.aui.Lab.entities.Tower;
import pl.edu.pg.eti.aui.Lab.services.ServiceForTower;
import pl.edu.pg.eti.aui.Lab.services.ServiceForTowerType;

import java.util.Optional;

@RestController
@RequestMapping("api/towers")
@AllArgsConstructor
public class ControllerForTower {

    private final ServiceForTower serviceForTower;
    private final ServiceForTowerType serviceForTowerType;


    @GetMapping
    public ResponseEntity<GetTowersResponse> getTowers(){
        return ResponseEntity.ok(GetTowersResponse.entityToDtoMapper().apply(serviceForTower.findAll()));
    }

    @GetMapping("{name}")
    public ResponseEntity<GetTowerResponse> getTower(@PathVariable("name") String name){
        return serviceForTower.find(name)
                .map(value -> ResponseEntity.ok(GetTowerResponse.entityToDtoMapper().apply(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createTower(@RequestBody CreateTowerRequest request, UriComponentsBuilder builder){
        Tower tower = CreateTowerRequest
                .dtoToEntityMapper(name -> serviceForTowerType.find(name).orElseThrow())
                .apply(request);
        serviceForTower.create(tower);
        return ResponseEntity.created(builder.pathSegment("api", "towers", "{name}")
                .buildAndExpand(tower.getName()).toUri()).build();
    }

    @DeleteMapping("{name}")
    public ResponseEntity<Void> deleteTower(@PathVariable("name") String name){
        Optional<Tower> tower = serviceForTower.find(name);
        if(tower.isPresent()){
            serviceForTower.delete(tower.get());
            return ResponseEntity.accepted().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping ("{name}")
    public ResponseEntity<Void> updateTower(@RequestBody UpdateTowerRequest request, @PathVariable("name") String name){
        Optional<Tower> tower = serviceForTower.find(name);
        if(tower.isPresent()){
            UpdateTowerRequest.dtoToEntityUpdater().apply(tower.get(), request);
            serviceForTower.update(tower.get());
            return ResponseEntity.accepted().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
