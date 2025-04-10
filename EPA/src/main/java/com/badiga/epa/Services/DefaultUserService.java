package com.badiga.epa.Services;

import com.badiga.epa.DTOS.UserDTO;
import com.badiga.epa.Exceptions.UserAlreadyExist;
import com.badiga.epa.Exceptions.UserNotFoundException;
import com.badiga.epa.Models.User;
import com.badiga.epa.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service("defaultUserService")
public class DefaultUserService implements UserServices{
    private UserRepository userRepository;
    public DefaultUserService(UserRepository UserRepository) {
        this.userRepository = UserRepository;
    }

    public Boolean validation(String email){
        User user = userRepository.findByEmail(email);
        if(user == null) {
            return true;
        }
        return false;

    }
    @Override
    public User signUp(UserDTO userDTO) throws UserAlreadyExist {
        if(validation(userDTO.getEmail())) {
            User user = User.builder()
                    .setName(userDTO.getName())
                    .setEmail(userDTO.getEmail())
                    .setPassword(userDTO.getPassword())
                    .setAddress(userDTO.getAddress())
                    .setPhoneNumber(userDTO.getPhoneNumber())
                    .build();
            userRepository.save(user);
            return user;
        }
        throw new UserAlreadyExist("User is already exist, please continue with shopping");

    }

    @Override
    public User getUser(Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId);
        if(user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }
}
