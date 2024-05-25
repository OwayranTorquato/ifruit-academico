package com.ifruitcommerce.ifruit.config;

import com.ifruitcommerce.ifruit.entities.User;
import com.ifruitcommerce.ifruit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Matheus", "matheus.avila@exemplo.com", "458742847238", "mat1234");
        User u2 = new User(null, "Joselino", "joselino@exemplo.com", "458742847234", "12345ADMIN");

        userRepository.saveAll(Arrays.asList(u1, u2));

    }
}
