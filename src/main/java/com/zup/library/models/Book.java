package com.zup.library.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Book {

    @Id
    @UuidGenerator
    private String id;
    private String title;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinTable(name = "books_consumers",
               joinColumns = @JoinColumn(name = "book_fk"),
               inverseJoinColumns = @JoinColumn(name = "consumers_fk"))
    private Set<Consumers> consumers = new HashSet<>();
}
