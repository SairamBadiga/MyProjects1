package com.badiga.bookmyshow.repositories;

import com.badiga.bookmyshow.models.Show_Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<Show_Seat, Long> {
}
