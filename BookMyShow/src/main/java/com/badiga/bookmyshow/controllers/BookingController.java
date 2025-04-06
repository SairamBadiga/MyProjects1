package com.badiga.bookmyshow.controllers;

import com.badiga.bookmyshow.dtos.BookingMovieRequestDTO;
import com.badiga.bookmyshow.exceptions.CustomerNotFoundException;
import com.badiga.bookmyshow.exceptions.ShowNotFoundException;
import com.badiga.bookmyshow.exceptions.ShowSeatNotFoundException;
import com.badiga.bookmyshow.models.Booking;
import com.badiga.bookmyshow.models.Show;
import com.badiga.bookmyshow.models.Show_Seat;
import com.badiga.bookmyshow.models.User;
import com.badiga.bookmyshow.services.BookingService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookingController {
    private BookingService bookingService;
    public BookingController() {}
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public Booking getBooking(BookingMovieRequestDTO bookingMovieRequestDTO) throws CustomerNotFoundException, ShowSeatNotFoundException, ShowNotFoundException {
        User user =  bookingMovieRequestDTO.getUser();
        Show show = bookingMovieRequestDTO.getShow();
        List<Show_Seat> seats = bookingMovieRequestDTO.getSeats();
        return bookingService.MovieTicket(user, show, seats);

    }
}
