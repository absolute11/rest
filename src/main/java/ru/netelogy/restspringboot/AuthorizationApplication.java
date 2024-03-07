package ru.netelogy.restspringboot;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.netelogy.restspringboot.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AuthorizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void initialize() {
        List<Authorities> denisAuthorities = Arrays.asList(Authorities.READ, Authorities.WRITE);
        userRepository.addUser("Denis", "1111", denisAuthorities);
        System.out.println("Добавлен");
    }
}