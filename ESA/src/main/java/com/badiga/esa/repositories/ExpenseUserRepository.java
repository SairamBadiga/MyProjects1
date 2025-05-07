package com.badiga.esa.repositories;

import com.badiga.esa.models.ExpenseUser;
import com.badiga.esa.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseUserRepository extends JpaRepository<ExpenseUserRepository, Long> {
    List<ExpenseUser> findAllByUser(User user);
}
