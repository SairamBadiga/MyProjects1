package com.badiga.epa.Services;

import com.badiga.epa.DTOS.UserDTO;
import com.badiga.epa.Exceptions.UserAlreadyExist;
import com.badiga.epa.Exceptions.UserNotFoundException;
import com.badiga.epa.Models.User;

public interface UserServices {
    public User signUp(UserDTO userDTO) throws UserAlreadyExist;
    public User getUser(Long orderId) throws UserNotFoundException;
}
