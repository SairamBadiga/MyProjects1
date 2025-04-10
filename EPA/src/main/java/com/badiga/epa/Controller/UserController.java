package com.badiga.epa.Controller;

import com.badiga.epa.DTOS.UserDTO;
import com.badiga.epa.Exceptions.UserAlreadyExist;
import com.badiga.epa.Models.User;
import com.badiga.epa.Services.UserServices;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
@RestController
public class UserController {
    private UserServices userServices;
    public UserController(@Qualifier("defaultUserService") UserServices userService) {
        this.userServices = userService;

    }
    @PostMapping("/signup")
    public UserDTO userSignup(@RequestBody UserDTO userDTO) throws UserAlreadyExist {
        User user = userServices.signUp(userDTO);
        UserDTO userdto = new UserDTO();
        userdto.setAddress(user.getAddress());
        userdto.setEmail(user.getEmail());
        userdto.setPassword(user.getPassword());
        userdto.setName(user.getName());
        userdto.setPhoneNumber(user.getPhoneNumber());
        return userdto;
    }



}


