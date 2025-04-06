package com.badiga.bookmyshow.services;

import com.badiga.bookmyshow.exceptions.CustomerNotFoundException;
import com.badiga.bookmyshow.exceptions.ShowNotFoundException;
import com.badiga.bookmyshow.exceptions.ShowSeatNotFoundException;
import com.badiga.bookmyshow.models.*;
import com.badiga.bookmyshow.repositories.BookingRepository;
import com.badiga.bookmyshow.repositories.ShowSeatRepository;
import com.badiga.bookmyshow.repositories.UserRepository;
import com.badiga.bookmyshow.repositories.ShowRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingRepository bookingRepository;

    public BookingService(ShowRepository showRepository, ShowSeatRepository showSeatRepository,
                          UserRepository userRepository,
                          BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;

    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking MovieTicket(User userId, Show showId, List<Show_Seat> show_SeatId) throws CustomerNotFoundException, ShowNotFoundException, ShowSeatNotFoundException {

        Optional<User> customer = userRepository.findById(userId.getId());

        if (customer.isPresent()) {
            throw new CustomerNotFoundException("Hey please login and book the ticket");
        }

        Optional<Show> show = showRepository.findById(showId.getId());

        if (!show.isPresent()) {
            throw new ShowNotFoundException("Hey this is not found");

        }
        List<Show_Seat> seats = showSeatRepository.findAll();
        for(Show_Seat seat : seats) {
            if(seat.getShowSeatStatus() != ShowSeatStatus.AVAILABLE){
                throw new ShowSeatNotFoundException("Hey seat is not found");

            }
        }
        for (Show_Seat seat : seats) {
            seat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
            showSeatRepository.save(seat);
        }
        Booking booking = new Booking();
        booking.setSeats(seats);
        booking.setUser(userId);
        booking.setAmount(100);
        bookingRepository.save(booking);
        return booking;


    }

}
