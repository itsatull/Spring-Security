package com.atul.springsecurityclient.service;

import com.atul.springsecurityclient.entity.User;
import com.atul.springsecurityclient.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
