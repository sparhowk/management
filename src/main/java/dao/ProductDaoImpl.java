package dao;

import api.ProductDao;
import entity.Product;
import entity.parser.ProductParser;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class ProductDaoImpl implements ProductDao {
    private String fileName;
    private String productType;

    public ProductDaoImpl(String fileName, String productType) throws IOException {
        this.fileName = fileName;
        this.productType = productType;
        FileUtils.createNewFile(fileName);
    }


    public void saveProduct(Product product) throws IOException {
        List<Product> products = getAllProducts();
        products.add(product);
        saveProducts(products);
    }

    public void saveProducts(List<Product> products) throws FileNotFoundException {
        PrintWriter writeToFile = new PrintWriter(new FileOutputStream(FileUtils.FILE_PATH+fileName, true));
        for (Product product: products ) {
            writeToFile.write(products.toString() + "\n");
        }
        writeToFile.close();
     }


    public void removeProductById(Long productId) throws IOException {
        List<Product> products = getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == productId) {
                products.remove(i);
            }
        }
    }

    public void removeProductByName(String productName) throws IOException {
        List<Product> products = getAllProducts();
        for (Product product:products ) {
            if (product.getProduktName().equals(productName)) {
                products.remove(product);
            }
        }
    }

    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<Product>();
        BufferedReader reader = new BufferedReader(new FileReader(FileUtils.FILE_PATH+fileName));

        String readLine = reader.readLine();
        while (readLine != null) {
            Product product = ProductParser.stringToProduct(readLine, productType );
            if (product != null) {
                products.add(product);
            }
        }
        reader.close();
        return products;
    }

    public Product getProductById(Long productId) throws IOException {
        List<Product> products = getAllProducts();

        for (Product product: products ) {
            boolean test = product.getId().equals(productId);
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public Product getProductByName(String productName)throws IOException {
        List<Product> products = getAllProducts();

        for (Product product: products ) {
            if (product.getProduktName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

}
