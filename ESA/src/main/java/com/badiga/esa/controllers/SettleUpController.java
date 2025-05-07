package com.badiga.esa.controllers;

import com.badiga.esa.dtos.SettleUpGroupRequestDTO;
import com.badiga.esa.dtos.SettleUpGroupResponseDTO;
import com.badiga.esa.dtos.SettleUpUserRequestDTO;
import com.badiga.esa.dtos.SettleUpUserResponseDTO;
import com.badiga.esa.models.Expense;
import com.badiga.esa.services.SettleUpService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {

    private SettleUpService settleUpService;

    public SettleUpController(SettleUpService settleUpService){
        this.settleUpService = settleUpService;
    }
    public SettleUpUserResponseDTO settleUpUser(SettleUpUserRequestDTO settleUpUserRequestDTO){

        List<Expense> expenseList = settleUpService.settleUpUser(settleUpUserRequestDTO.getUserId());

        SettleUpUserResponseDTO settleUpUserResponseDTO = new SettleUpUserResponseDTO();
        settleUpUserResponseDTO.setTransactionsList(expenseList);

        return settleUpUserResponseDTO;
    }

    public SettleUpGroupResponseDTO settleUpGroup(SettleUpGroupRequestDTO settleUpGroupRequestDTO){
        return null;
    }
}