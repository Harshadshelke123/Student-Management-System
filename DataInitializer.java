package com.cwm.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cwm.demo.model.Users;
import com.cwm.demo.repository.UsersRepository;

@Configuration
public class DataInitializer {

    private final UsersRepository usersRepository;

    public DataInitializer(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Bean
    CommandLineRunner loadSampleData(PasswordEncoder passwordEncoder) {
        return args -> {

            if (!usersRepository.existsByUsername("Admin")) {

                Users users = new Users();
                users.setUsername("Admin");
                users.setPassword(passwordEncoder.encode("123456"));
                users.setActive(true);

                usersRepository.save(users);
            }
        };
    }
}
