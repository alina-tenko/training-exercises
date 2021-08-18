package ua.training.kondratenko.cargodelivery.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "cities")
public class Cities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "distance")
    private Long distance;

    @OneToMany(targetEntity = Addresses.class, cascade = CascadeType.ALL, mappedBy = "cityId")
    @ToString.Exclude
    private List<Addresses> addresses = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cities cities = (Cities) o;

        return Objects.equals(id, cities.id);
    }

    @Override
    public int hashCode() {
        return 252728603;
    }
}