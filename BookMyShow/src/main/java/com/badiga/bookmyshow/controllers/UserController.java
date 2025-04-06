package com.badiga.bookmyshow.controllers;

import com.badiga.bookmyshow.dtos.UserDTO;
import com.badiga.bookmyshow.models.User;
import com.badiga.bookmyshow.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;

    }


}
