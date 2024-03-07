package ru.netelogy.restspringboot.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netelogy.restspringboot.Authorities;
import ru.netelogy.restspringboot.InvalidCredentials;
import ru.netelogy.restspringboot.UnauthorizedUser;
import ru.netelogy.restspringboot.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
@Service
public class AuthorizationService {
    @Autowired
    UserRepository userRepository;

    public void initializeUsers() {
        List<Authorities> denisAuthorities = Arrays.asList(Authorities.READ, Authorities.WRITE);
        userRepository.addUser("Denis", "1111", denisAuthorities);
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}