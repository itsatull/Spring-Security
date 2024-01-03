package com.atul.springsecurityclient.event.listener;

import com.atul.springsecurityclient.entity.User;
import com.atul.springsecurityclient.event.RegistrationCompleteEvent;
import com.atul.springsecurityclient.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {

        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token,user);
        //sent Mail to User
        //Create the verfication token for the user with link--sendVerificationEmail()
        String url = event.getApplicationUrl() + "verifyRegistration?token"+token;
        log.info("Click the link to verify your account:{}",url);

    }
}
