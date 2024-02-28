package com.authentication.service;

import com.authentication.entity.UserInfo;
import com.authentication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.authentication.constants.AuthenticationConstants.USER_NOT_FOUND_EXCEPTION_PLACEHOLDER;


@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userDto = userRepository.findByUsername(username);
        if (Objects.isNull(userDto))
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_EXCEPTION_PLACEHOLDER,username));
        return new MyUserDetails(userDto);
    }
}
