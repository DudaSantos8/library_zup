package com.zup.library.repositories;


import com.zup.library.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.SecureRandom;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
