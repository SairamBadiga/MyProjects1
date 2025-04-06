package com.badiga.bookmyshow.services;

import com.badiga.bookmyshow.exceptions.UserAlreadyExists;
import com.badiga.bookmyshow.models.User;
import com.badiga.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signUp(String userName, String password, String email) throws UserAlreadyExists {

        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(userName));
        if(!user.isPresent()){
            throw new UserAlreadyExists("Hey no need to create account. kindly proceed to book a ticket");
        }
        else{
            User newUser = new User();
            newUser.setName(userName);
            newUser.setEmail(email);
            newUser.setPassword(password);
            userRepository.save(newUser);
            return newUser;
        }




    }

}
