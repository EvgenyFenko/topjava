package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.List;

public class UserUtil {

    public static final List<User> USERS = Arrays.asList(
        new User(1, "auser1", "email1@email.com", "pass1", Role.USER),
        new User(2, "cuser2", "email2@email.com", "pass2", Role.USER),
        new User(3, "buser3", "email3@email.com", "pass3", Role.ADMIN));
}
