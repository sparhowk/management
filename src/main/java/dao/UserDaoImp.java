package dao;

import entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import entity.parser.UserParser;
import utils.FileUtils;

import static utils.FileUtils.*;

public class UserDaoImp implements api.UserDao {
    private String fileName;
    private String filePath = FILE_PATH;

    public UserDaoImp(String fileName)  throws IOException {
        this.fileName = fileName;
        createNewFile(fileName);
    }

    public void saveUser(User user) throws IOException {
        List<User> users = getAllUsers();
        users.add(user);
        saveUsers(users);

    }

    public void saveUsers(List<User> users) throws IOException {
        PrintWriter writeToFile = new PrintWriter(new FileOutputStream(FileUtils.FILE_PATH+fileName, true));
        for (User user: users) {
            writeToFile.write(users.toString() + "\n");
        }
        writeToFile.close();
    }

    public List<User> getAllUsers() throws IOException {
        List<User> users = new ArrayList<User>();
        BufferedReader reader = new BufferedReader(new FileReader(FileUtils.FILE_PATH+fileName));

        String readLine = reader.readLine();
        while (readLine != null) {
            User user = UserParser.convertToUser(readLine);
            users.add(user);
        }
        reader.close();
        return users;
    }

    public User getUserByLogin(String login) throws IOException {
        List<User> users = getAllUsers();
        for (User user: users ) {
            boolean isFoundUser = user.getLogin().equals(login);
            if (isFoundUser) {
                return user;
            }
        }
        return null;
    }

    public User getUserById(Long userId) throws IOException {
        List<User> users = getAllUsers();
        for (User user: users ) {
            boolean isFounfUser = user.getId().equals(userId);
            if (isFounfUser) {
                return user;
            }
        }
        return null;
    }

    public void removeUserByLogin(String login) throws IOException {
        List<User> users = getAllUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(login)) {
                users.remove(i);
            }
        }
    }

    public void removeUserById(Long userId) throws IOException {
        List<User> users = getAllUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == userId) {
                users.remove(i);
            }
        }
    }
}
