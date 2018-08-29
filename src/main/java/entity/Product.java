package entity;

public class Product {
    private Long id;
    private String productName;
    private float price;
    private float weight;
    private String color;
    private int productCount;
    public final static String PRODUCT_SEPRATOR = "#";


    public Product(Long id, String productName, Float price, Float weight, String color, Integer productCount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount=productCount;
    }

    public Long getId() {
        return id;
    }

    public String getProduktName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }

    public float getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return id + PRODUCT_SEPRATOR + productName + PRODUCT_SEPRATOR + price
                + weight + PRODUCT_SEPRATOR + color + PRODUCT_SEPRATOR + productCount;

    }
}
