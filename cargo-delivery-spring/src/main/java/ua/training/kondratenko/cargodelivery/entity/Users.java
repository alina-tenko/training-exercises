package ua.training.kondratenko.cargodelivery.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", unique = true, nullable = false, length = 32)
    private String userName;


    @Column(name = "password", unique = true, nullable = false, length = 32)
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

}