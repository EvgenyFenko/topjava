package ru.javawebinar.topjava.repository.inmemory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;
import ru.javawebinar.topjava.util.UserUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryUserRepository implements UserRepository {

    private static final Logger log = LoggerFactory.getLogger(InMemoryUserRepository.class);
    private List<User> repository = new ArrayList<>();

    {
        UserUtil.USERS.forEach(this::save);
    }

    @Override
    public boolean delete(int id) {
        log.info("delete {}", id);
        User userToDelete = repository.stream().filter(user -> (user.getId() == id))
                .collect(Collectors.toList()).get(0);
        return repository.remove(userToDelete);
    }

    @Override
    public User save(User user) {
        log.info("save {}", user);
        repository.add(user);
        return user;
    }

    @Override
    public User get(int id) {
        log.info("get {}", id);
        try {
            return repository.stream().filter(user -> (user.getId() == id)).collect(Collectors.toList()).get(0);
        } catch (Exception e) {
            System.out.println("No found user with id " + id);
            return null;
        }
    }

    @Override
    public List<User> getAll() {
        log.info("getAll");
//        return Collections.emptyList();
        return repository.stream().sorted(Comparator.comparing(User::getName)).collect(Collectors.toList());
    }

    @Override
    public User getByEmail(String email) {
        log.info("getByEmail {}", email);
        try {
            return repository.stream().filter(user -> (user.getEmail().equals(email))).collect(Collectors.toList()).get(0);
        } catch (Exception e) {
            System.out.println("No user with email " + email);
            return null;
        }
    }
}
