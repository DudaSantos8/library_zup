package com.zup.library.models;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    @Id
    @UuidGenerator
    private String id;
    private String title;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinTable(name = "books_users",
               joinColumns = @JoinColumn(name = "book_fk"),
               inverseJoinColumns = @JoinColumn(name = "user_fk"))
    private Set<EndUser> endUser = new HashSet<>();

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<EndUser> getEndUser() {
        return endUser;
    }

    public void setEndUser(Set<EndUser> endUser) {
        this.endUser = endUser;
    }
}
