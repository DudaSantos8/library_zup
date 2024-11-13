package com.zup.library.repositories;


import com.zup.library.models.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EndUserRepository extends JpaRepository<EndUser, Long> {
    Optional<EndUser> findByName(String name);
}
