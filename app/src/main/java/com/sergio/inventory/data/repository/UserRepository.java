package com.sergio.inventory.data.repository;

import com.sergio.inventory.data.model.User;
import com.sergio.inventory.data.model.UserType;

import java.util.ArrayList;

public class UserRepository {
    private static UserRepository repository;
    private ArrayList<User> users;
    private int id;

    static {
        repository = new UserRepository();
    }

    private UserRepository() {
        users = new ArrayList<>();
        initialize();
    }

    public static UserRepository getInstance() {
        return repository;
    }
    public void initialize() {
        add(new User(1, "lourdes", "Lourdes18?", "Lourdes Rodriguez", "lourdes@iesportada.org", "/img/lourdes", UserType.MANAGER));
        add(new User(2, "jesus", "Jesus19?", "Jesus González", "jesus@iesportada.org", "/img/jesus", UserType.TECHNICAL));
        add(new User(3, "ana", "Ana20?", "Ana García", "ana@iesportada.org", "/img/angela", UserType.ADMIN));
        id = 4;
    }
    public void add(User user) {
        users.add(user);
    }
    public void add(String useraux, String password, String email) {
        User user = new User(id++, useraux, password, useraux, email, "/img/" + useraux, UserType.TECHNICAL);
        users.add(user);
    }
    public boolean userExists(String useraux) {
        for (User user : users) {
            if (user.getUser().equals(useraux))
                return true;
        }
        return false;
    }
    public boolean validateCredentials(String useraux, String password) {
        for (User user : users) {
            if (user.getUser().equals(useraux) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }
}