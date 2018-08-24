package service;

import api.ProductService;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    List<Product> products;

    public ProductServiceImpl() {
        this.products = new ArrayList<Product>();
    }

    public ProductServiceImpl(List<Product> product){
        this.products = product;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Integer countAllProducts() {
        return products.size();
    }

    public Product getProductByProductName(String productName) {
        for (Product product : products){
            if (product.getProduktName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public boolean isProductOnWerhouse(String productName) {
        for (Product product : products) {
            if (isProductNameExist(productName) && (product.getProductCount() > 0)) {
                return true;
            }
        }
        return false;
    }

    public boolean isProductNameExist(String produktName) {
        for (Product product: products) {
            if (product.getProduktName().equals(produktName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isProduktIdExist(Long produktId){
        for (Product product: products) {
            if (product.getId() == produktId) {
                return true;
            }
        }
        return false;
    }
}
