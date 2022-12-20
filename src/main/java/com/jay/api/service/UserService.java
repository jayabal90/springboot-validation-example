package com.jay.api.service;

import com.jay.api.dto.UserRequest;
import com.jay.api.entity.User;
import com.jay.api.exception.UserNotFoundException;
import com.jay.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequest userRequest){
        User user = User.
                build(0,userRequest.getName(),userRequest.getEmail(),
                        userRequest.getMobile(),userRequest.getGender(),userRequest.getAge(),userRequest.getNationality());
        return userRepository.save(user);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUser(int id) throws UserNotFoundException {
        User user= userRepository.findByUserId(id);
        if(user!=null){
            return user;
        }else {
            throw new UserNotFoundException("user not found with id : "+id);
        }
    }

}
