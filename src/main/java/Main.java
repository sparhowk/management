import api.ProductDao;
import api.UserDao;
import dao.ProductDaoImpl;
import dao.UserDaoImp;
import entity.Boots;
import entity.Cloth;
import entity.User;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        User user = new User(1l, "admin", "admin");
        Boots boots01 = new Boots(1l,"itemBoots1", 12.57f, 1.99f, "red", 20, 41, true);
        Cloth cloth01 = new Cloth(1l, "itemCloth1", 30.99f, 1.01f, "blue", 10, "S", "cooton");

        ProductDao productClothDao = new ProductDaoImpl("cloth", "CLOTH");
        productClothDao.saveProduct(cloth01);

        ProductDao productBootsDao = new ProductDaoImpl("boots", "BOOTS");
        productBootsDao.saveProduct(boots01);

        UserDao userDao = new UserDaoImp("users");
        userDao.saveUser(user);


    }
}
