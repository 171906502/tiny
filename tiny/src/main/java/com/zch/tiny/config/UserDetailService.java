package com.zch.tiny.config;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.zch.tiny.model.User;
import com.zch.tiny.model.AuthUser;

import com.zch.tiny.repository.UserRepository;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Component
public class UserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User eu = new User();
        eu.setUsername(username);
        Optional<User> user = userRepository.findBy(Example.of(eu), q -> q.one());
        if (user.isPresent()) {
            var u = new AuthUser();
            BeanUtils.copyProperties(user,u);
            return u;
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

}
