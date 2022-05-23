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
public class Tower {

    private String name;
    private int range;
    private int attackSpeed;
    private TowerType type;
    private int cost;
    private int damage;
}
