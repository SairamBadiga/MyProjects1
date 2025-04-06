package com.badiga.bookmyshow;

import com.badiga.bookmyshow.controllers.BookingController;
import com.badiga.bookmyshow.dtos.BookingMovieRequestDTO;
import com.badiga.bookmyshow.models.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class BookMyShowApplication {

    public static void main(String[] args) {

        SpringApplication.run(BookMyShowApplication.class, args);
    }

}
