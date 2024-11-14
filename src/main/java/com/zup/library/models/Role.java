package com.zup.library.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
@Table(name = "roles")
public class Role {
    @Id
    @UuidGenerator
    private String id;
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }
}
