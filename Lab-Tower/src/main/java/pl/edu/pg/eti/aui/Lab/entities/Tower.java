package pl.edu.pg.eti.aui.Lab.entities;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "tower")
public class Tower {

    @Id
    private String name;

    private int range;

    @Column(name = "attack_speed")
    private int attackSpeed;

    @ManyToOne
    @JoinColumn(name ="tower_type")
    private TowerType towerType;

    private int cost;

    private int damage;
}
