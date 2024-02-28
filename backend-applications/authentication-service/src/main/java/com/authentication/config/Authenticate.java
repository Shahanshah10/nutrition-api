package com.authentication.config;

import com.authentication.dto.JwtRequest;
import com.authentication.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class Authenticate {


    private final AuthenticationManager authenticationManager;

    public void authenticate(JwtRequest jwtRequest) throws UserNotFoundException {
        try {
            log.info("Authentication started....");
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
            log.info("Authentication successfully..");
        } catch (DisabledException e) {
            log.error("Authentication is failed...");
            throw new UserNotFoundException("USER_DISABLED");
        } catch (BadCredentialsException e) {
            log.error("Authentication is failed...");
            throw new UserNotFoundException(String.format("Username or Password is incorrect %s",jwtRequest.getUsername()));
        }
    }
}
