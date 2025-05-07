package com.badiga.esa.dtos;


import com.badiga.esa.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpUserResponseDTO {
    private List<Expense> transactionsList;
}