package service;

import api.UserService;
import dao.UserDaoImp;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

import java.io.IOException;
import java.util.List;

public class UserServiceImp implements UserService {
    private static UserServiceImp instance = null;

    UserDaoImp userDaoInstance = UserDaoImp.getInstance();
    UserValidator userValidatorInstance = UserValidator.getInstance();

    private UserServiceImp() throws IOException {
    }

    public static UserServiceImp getInstance() throws IOException {
        if (instance == null) {
            instance = new UserServiceImp();
        }
        return instance;
    }

    public List<User> getAllUsers() throws IOException {
        return userDaoInstance.getAllUsers();
    }

    public void addUser(User user) throws IOException, UserShortLengthLoginException, UserShortLengthPasswordException, UserLoginAlreadyExistException {
        if (userValidatorInstance.isValidate(user)) {
            userDaoInstance.saveUser(user);
        }
    }

    public void removeUserById(Long userId) throws IOException {
        userDaoInstance.removeUserById(userId);
    }
}
