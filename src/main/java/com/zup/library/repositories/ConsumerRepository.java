package com.zup.library.repositories;


import com.zup.library.models.Consumers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumers, String> {
    Optional<Consumers> findByUsername(String name);

    boolean existsByUsername(String name);
}
