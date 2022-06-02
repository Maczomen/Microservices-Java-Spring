package pl.edu.pg.eti.aui.Lab.dto;

import lombok.*;
import pl.edu.pg.eti.aui.Lab.entities.TowerType;

import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class CreateTowerTypeRequest {
    private String name;

    public static Function<CreateTowerTypeRequest, TowerType> dtoToEntityMapper() {
        return request -> TowerType.builder()
                .name(request.getName())
                .build();
    }
}
