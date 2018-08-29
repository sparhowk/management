package entity.parser;

import entity.Product;
import entity.User;

public class UserParser {
    public static User convertToUser(String usersString) {
        String [] userInformation = usersString.split(Product.PRODUCT_SEPRATOR);

        long id = Long.parseLong(userInformation[0]);
        String login = userInformation[1];
        String password = userInformation[2];

        return new User(id, login, password);
    }
}
