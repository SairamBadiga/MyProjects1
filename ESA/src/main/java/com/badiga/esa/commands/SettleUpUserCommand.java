package com.badiga.esa.commands;
import com.badiga.esa.controllers.SettleUpController;
import com.badiga.esa.dtos.SettleUpUserRequestDTO;
import com.badiga.esa.dtos.SettleUpUserResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpUserCommand implements Command{

    SettleUpController settleUpController;


    public SettleUpUserCommand(SettleUpController settleUpController){
        this.settleUpController = settleUpController;
    }
    @Override
    public boolean matches(String input) {
        //1234, SettleUp => no of words - 2
        List<String> words = List.of(input.split(" "));

        return words.size() == 2 && words.get(1).equals(CommandKeywords.SettleUpUserCommand);
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));

        Long userId = Long.valueOf(words.get(0));

        SettleUpUserRequestDTO settleUpUserRequestDTO = new SettleUpUserRequestDTO();

        settleUpUserRequestDTO.setUserId(userId);

        SettleUpUserResponseDTO settleUpUserResponseDTO = settleUpController.settleUpUser(settleUpUserRequestDTO);
    }
}