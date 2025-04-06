package com.badiga.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    @ManyToMany
    private List<Show_Seat> seats;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus status;
    private int amount;
    @OneToMany
    private List<Payment> payments;
}
