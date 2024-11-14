package com.zup.library.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Consumers {
    @Id
    @UuidGenerator
    private String id;
    private String username;
    private String lastName;
    private int yearOfBirth;
    private int yearOfDeath;
    private String password;

    @ManyToMany(mappedBy = "consumers")
    private Set<Book> book = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_consumers",
            joinColumns = @JoinColumn(name = "role_fk"),
            inverseJoinColumns = @JoinColumn(name = "consumers_fk"))
    private Set<Role> roles;
}
