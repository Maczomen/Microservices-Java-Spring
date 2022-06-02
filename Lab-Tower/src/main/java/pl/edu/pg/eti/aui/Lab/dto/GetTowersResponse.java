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
public class GetTowersResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Tower {

        private String name;
    }

    @Singular
    private List<Tower> towers;

    public static Function<Collection<pl.edu.pg.eti.aui.Lab.entities.Tower>, GetTowersResponse> entityToDtoMapper() {
        return towerTypes -> {
            GetTowersResponseBuilder response = GetTowersResponse.builder();
            towerTypes.stream()
                    .map(tower -> Tower.builder()
                            .name(tower.getName())
                            .build())
                    .forEach(response::tower);
            return response.build();
        };
    }
}
