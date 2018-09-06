package service;
import dao.UserDaoImp;

import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

import java.io.IOException;

public class UserValidator {
    UserDaoImp userDaoImp = UserDaoImp.getInstance();
    private static UserValidator instance = null;

    private UserValidator() throws IOException {
    }

    public static UserValidator getInstance() throws IOException {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    private boolean isUserLoginCorrect(String userLogin) throws UserShortLengthLoginException {
        return userLogin.length() >= 4;
    }

    private boolean isUserPasswordCorrect(String userPassword) throws UserShortLengthPasswordException {
        return userPassword.length() >= 6;
    }

    private boolean isUserByLoginExist(String userLogin) throws IOException, UserLoginAlreadyExistException {
        User isFoundUser = userDaoImp.getUserByLogin(userLogin);
        if (isFoundUser.getLogin().equals(userLogin)) {
            return true;
        }
        return false;
    }

    public boolean isValidate(User user) throws UserShortLengthLoginException, UserShortLengthPasswordException, IOException, UserLoginAlreadyExistException {
        if (!isUserLoginCorrect(user.getLogin())) {
            throw new UserShortLengthLoginException("Login: " + user.getLogin() + " is to short.");
        }

        if (!isUserPasswordCorrect(user.getPassword())) {
            throw new UserShortLengthPasswordException("Password is to short");
        }

        if (isUserByLoginExist(user.getLogin())) {
            throw new UserLoginAlreadyExistException("User already exist in system!");
        }
        return true;
    }
}
