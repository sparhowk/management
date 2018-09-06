package service;

import api.ProductService;
import dao.ProductDaoImpl;
import entity.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static ProductServiceImpl instance = null;
    ProductDaoImpl productDaoInstancen = ProductDaoImpl.getInstance();


    private ProductServiceImpl() throws IOException {
    }

    public static ProductServiceImpl getInstance() throws IOException {
        if (instance==null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    public List<Product> getAllProducts() throws IOException {
        return productDaoInstancen.getAllProducts();
    }

    public Integer countAllProducts() throws IOException {
        return getAllProducts().size();
    }

    public Product getProductByProductName(String productName) throws IOException {
        return productDaoInstancen.getProductByName(productName);
    }

    public boolean isProductOnWerhouse(String productName) throws IOException {
        Product product = getProductByProductName(productName);
        if (product != null && product.getProductCount() > 0) return true;
        return false;
    }

    public boolean isProductNameExist(String productName) throws IOException {
        Product product = getProductByProductName(productName);
        if (product == null) return false;
        return true;
    }

    public boolean isProduktIdExist(Long productId) throws IOException {
        Product product = productDaoInstancen.getProductById(productId);
        if (product == null) return false;
        return true;
    }
}
