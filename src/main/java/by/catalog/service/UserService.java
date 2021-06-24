package by.catalog.service;

import by.catalog.entity.User;
import by.catalog.storage.UserStorage;

import java.util.Arrays;
import java.util.List;

public class UserService {

    private UserStorage userStorage = new UserStorage();

    public void saveUser(String firstName, String lastName, String password, String login, String role) {
        userStorage.addUser(new User(firstName, lastName, login, password, role));
    }

    public User getUserByLoginAndPassword(String login, String password) {
        User userByLogin = userStorage.getUserByLogin(login);
        if (userByLogin != null) {
            if (userByLogin.getPassword().equals(password)) {
                return userByLogin;
            } else return null;
        } else return null;
    }

    public String checkLoginAndPassword(String login, String password) {
        User userByLogin = userStorage.getUserByLogin(login);
        if (userByLogin == null) {
            return "login incorrect";
        } else
            return "password incorrect";
    }

    public List<User> allUsersList(){
        return userStorage.getAllUser();
    }

    public long[] userIdFromCreateBoard (String[] arrayId){
        long[] arrayLong = new long[arrayId.length];
        for (int i = 0; i < arrayId.length; i++) {
            long l = Long.parseLong(arrayId[i]);
            arrayLong[i] = l;
        }
        return arrayLong;
    }
}

