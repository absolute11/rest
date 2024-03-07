package ru.netelogy.restspringboot.repository;

import org.springframework.stereotype.Repository;
import ru.netelogy.restspringboot.Authorities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private Map<String, List<Authorities>> userAuthoritiesMap = new HashMap<>();

    public void addUser(String user, String password, List<Authorities> authorities) {
        userAuthoritiesMap.put(user, authorities);
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (userAuthoritiesMap.containsKey(user)) {
            return userAuthoritiesMap.get(user);
        } else {
            return List.of();
        }
    }

}