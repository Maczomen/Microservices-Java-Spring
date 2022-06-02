package pl.edu.pg.eti.aui.Lab.dto;

import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetTowerTypesResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class TowerType {

        private String name;
    }

    @Singular
    private List<TowerType> towerTypes;

    public static Function<Collection<pl.edu.pg.eti.aui.Lab.entities.TowerType>, GetTowerTypesResponse> entityToDtoMapper() {
        return towerTypes -> {
            GetTowerTypesResponseBuilder response = GetTowerTypesResponse.builder();
            towerTypes.stream()
                    .map(towerType -> TowerType.builder()
                            .name(towerType.getName())
                            .build())
                    .forEach(response::towerType);
            return response.build();
        };
    }
}
