package com.badiga.epa.Repositories;

import com.badiga.epa.Models.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Id> {

    User findByEmail(String email);
    User findById(Long id);
}
