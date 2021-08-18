package ua.training.kondratenko.cargodelivery.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "addresses")
public class Addresses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_id")
    private Long cityId;

    @Column(name = "street")
    private String street;

    @Column(name = "home")
    private String home;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Addresses addresses = (Addresses) o;

        return Objects.equals(id, addresses.id);
    }

    @Override
    public int hashCode() {
        return 2058356308;
    }
}