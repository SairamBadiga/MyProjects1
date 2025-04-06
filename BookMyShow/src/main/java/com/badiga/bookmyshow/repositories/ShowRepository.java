package com.badiga.bookmyshow.repositories;

import com.badiga.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

    @Override
    List<Show> findAllById(Iterable<Long> longs);


}
