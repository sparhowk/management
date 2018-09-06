package api;

import entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts() throws IOException;

    //zwrócenie ilości produktow na liście
    Integer countAllProducts() throws IOException;

    //zwrócenie Product poprzez productName – jeżeli nie istnieje to null
    Product getProductByProductName(String productName) throws IOException;

    //sprawdzenie czy ilość produktu jest większa od 0 dla konkretnego productName
    boolean isProductOnWerhouse(String productName) throws IOException;

    //sprawdzenie czy produkt o podanym productName istnieje
    boolean isProductNameExist(String produktName) throws IOException;

    //sprawdzenie czy produkt o podanym id istnieje
    boolean isProduktIdExist(Long produktId) throws IOException;
}
