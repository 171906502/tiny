package com.zch.tiny.help;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.zch.tiny.model.User;
import com.zch.tiny.model.UserRole;
import com.zch.tiny.model.UserRoleId;
import com.zch.tiny.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class Init {


    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initUser(){
        log.info("add init admin user");
        return new CommandLineRunner() {
            public void run(String... args) throws Exception{
                User u  =new User();
                u.setId(1);
                u.setUsername("admin");
                if (!repository.findOne(Example.of(u)).isPresent()){
                    u.setPassword(passwordEncoder.encode("123456"));
                    repository.save(u);
                }

            }
          
        };
    }
    
    
}
