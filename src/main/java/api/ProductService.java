package api;

import entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    //zwrócenie ilości produktow na liście
    Integer countAllProducts();

    //zwrócenie Product poprzez productName – jeżeli nie istnieje to null
    Product getProductByProductName(String productName);

    //sprawdzenie czy ilość produktu jest większa od 0 dla konkretnego productName
    boolean isProductOnWerhouse(String productName);

    //sprawdzenie czy produkt o podanym productName istnieje
    boolean isProductNameExist(String produktName);

    //sprawdzenie czy produkt o podanym id istnieje
    boolean isProduktIdExist(Long produktId);
}
