package com.badiga.bookmyshow.dtos;

import com.badiga.bookmyshow.models.Show;
import com.badiga.bookmyshow.models.Show_Seat;
import com.badiga.bookmyshow.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingMovieRequestDTO {
    User user;
    Show show;
    List<Show_Seat> seats;

}
