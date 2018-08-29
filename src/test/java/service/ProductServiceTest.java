package service;

import entity.Boots;
import entity.Cloth;
import entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    @Test
    public void testGetAllProductsPositive() {
        //is
        List<Product> products = new ArrayList<Product>();
        Product item1 = new Boots(1l, "item1", 12.6f, 11.12f, "red", 16, 43, true);

        products.add(item1);
        products.add(new Cloth(2l,"item2", 12.6f, 11.12f, "red", 16,"L", "Cotton"));

        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        List<Product> productsFromTheClass = productService.getAllProducts();

        //expected
        Assert.assertEquals(products, productsFromTheClass);
    }

    @Test
    public void testGetAllProductNegative() {
        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(1l, "item1", 12.6f, 11.12f, "red", 16, 43, true));
        products.add(new Cloth(2l,"item2", 12.6f, 11.12f, "red", 16,"L", "Cotton"));
        //then
        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
        products.add(new Boots(3l,"item3",12.6f,11.12f,"red",16,43,true));

        List<Product> productsFromTheClass = productService.getAllProducts();

        //expected
        Assert.assertNotEquals(products, productsFromTheClass);
    }

    @Test
    public void testCountProductsWithProducts(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(1l, "item1", 12.6f, 11.12f, "red", 16, 43, true));
        products.add(new Cloth(2l,"item2", 12.6f, 11.12f, "red", 16,"L", "Cotton"));

        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final int result = productService.countAllProducts();

        Assert.assertEquals(2, result);
    }

    @Test
    public void testCountProductsWithoutProducts() {
        ProductServiceImpl productService = new ProductServiceImpl();

        final int result = productService.countAllProducts();

        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetProductByProductNameWhenExist() {
        List<Product> products = new ArrayList<Product>();
        Product item1 = new Boots(1l, "item1", 12.6f, 11.12f, "red", 16, 43, true);
        products.add(item1);
        products.add(new Cloth(2l,"item2", 12.6f, 11.12f, "red", 16,"L", "Cotton"));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product product = productService.getProductByProductName("item1");

        Assert.assertEquals(item1, product);
    }

    @Test
    public void testGetProductByProductNameWhenNotExist() {
        List<Product> products = new ArrayList<Product>();
        Product item1 = new Boots(1l, "item1", 12.6f, 11.12f, "red", 16, 43, true);
        products.add(item1);
        products.add(new Cloth(2l,"item2", 12.6f, 11.12f, "red", 16,"L", "Cotton"));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product product = productService.getProductByProductName("item3");

        Assert.assertEquals(null, product);
    }

    @Test
    public void testIsProductOnWerhouseIsIn(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(2l,"item2", 12.6f, 11.12f, "red", 16,"L", "Cotton"));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean productOnWerhouse = productService.isProductOnWerhouse("item1");

        Assert.assertTrue(productOnWerhouse);

    }

    @Test
    public void testIsProductOnWerhouseIsNotIn(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(2l,"item2", 12.6f, 11.12f, "red", 16,"L", "Cotton"));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean productOnWerhouse = productService.isProductOnWerhouse("item1");

        Assert.assertFalse(productOnWerhouse);
    }

    @Test
    public void testIsProductNameExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(2l,"item2", 12.6f, 11.12f, "red", 16,"L", "Cotton"));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductNameExist = productService.isProductNameExist("item1");

        Assert.assertTrue(isProductNameExist);
    }

    @Test
    public void testIsProductNameNotExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(2l,"item2", 12.6f, 11.12f, "red", 16,"L", "Cotton"));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductNameExist = productService.isProductNameExist("item2");

        Assert.assertFalse(isProductNameExist);
    }

    @Test
    public void testIsProduktIdExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(2l,"item2", 12.6f, 11.12f, "red", 16,"L", "Cotton"));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductIdExist = productService.isProduktIdExist(1l);

        Assert.assertTrue(isProductIdExist);
    }

    @Test
    public void testIsProduktIdNotExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(2l,"item2", 12.6f, 11.12f, "red", 16,"L", "Cotton"));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductIdExist = productService.isProduktIdExist(10l);

        Assert.assertTrue(isProductIdExist);
    }

}
