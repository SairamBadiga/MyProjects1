package com.badiga.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private int amount;
    private String referenceNo;
    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
}
