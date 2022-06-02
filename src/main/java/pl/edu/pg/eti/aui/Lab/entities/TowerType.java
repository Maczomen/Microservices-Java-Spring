package pl.edu.pg.eti.aui.Lab.entities;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "tower_types")
public class TowerType {

    @Id
    private String name;

    @Column(name = "bonus_name")
    private String bonusName;

    @Column(name = "bonus_strength")
    private int bonusStrength;

    @OneToMany(mappedBy = "towerType", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<Tower> towers;
}
