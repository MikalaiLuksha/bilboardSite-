package by.catalog.service;

import by.catalog.entity.User;
import by.catalog.storage.UserStorage;

public class UserService {

    private UserStorage userStorage = new UserStorage();

    public void saveUser (String firstName, String lastName, String password, String login, String role){
        userStorage.addUser(new User(firstName, lastName, password, lastName, role));
    }

    public User getUserByLoginAndPassword(String login, String password){
        User userByLogin = userStorage.getUserByLogin(login);
        if (userByLogin.getPassword().equals(password)){
            return userByLogin;
        }
        else return null;
    }
}
