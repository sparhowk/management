package service;

import api.UserService;
import dao.UserDaoImp;
import entity.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance = null;

    List<User> users;

    UserDaoImp userDaoInstance = UserDaoImp.getInstance();
    UserValidator userValidatorInstance = UserValidator.getInstance();

    private UserServiceImpl() throws IOException {
        this.users = new ArrayList<User>();
    }

//    public UserServiceImpl(List<User> users) throws IOException {
//        this.users = users;
//    }

    public static UserServiceImpl getInstance() throws IOException {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    public List<User> getAllUsers() throws IOException {
        return userDaoInstance.getAllUsers();
    }

//    public void addUser(User user) throws IOException {
    public void addUser(String userName, String password) throws IOException {
        if (true) {

            long id = 1l;
            userDaoInstance.saveUser(new User(id,userName, password));
        }
    }

    public void removeUserById(Long userId) {
        for (int i = 0; i < users.size(); i++) {
            User userFromList = users.get(i);
            if (userFromList.getId() == userId) {
                users.remove(i);
                break;
            }

        }
    }
}
