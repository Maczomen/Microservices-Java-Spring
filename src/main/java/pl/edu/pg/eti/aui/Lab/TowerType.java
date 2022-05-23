package pl.edu.pg.eti.aui.Lab;


import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TowerType {

    private String name;
    private String bonusName;
    private int bonusStrength;
}
