package com.badiga.bookmyshow.MyRunner;

import com.badiga.bookmyshow.controllers.BookingController;
import com.badiga.bookmyshow.dtos.BookingMovieRequestDTO;
import com.badiga.bookmyshow.models.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {
    BookingController bookingController;
    public MyRunner(BookingController bookingController) {
        this.bookingController = bookingController;

    }
    @Override
    public void run(String... args) throws Exception {
        BookingMovieRequestDTO bookingMovieRequestDTO = new BookingMovieRequestDTO();

        bookingController.getBooking(bookingMovieRequestDTO);

    }
}
