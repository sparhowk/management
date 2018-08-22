package entity;

public class Product {
    private long id;
    private String produktName;
    private float price;
    private float weight;
    private String color;
    private int productCount;

        public Product(Buldier buldier) {
        this.id = buldier.id;
        this.produktName = buldier.produktName;
        this.price = buldier.price;
        this.weight = buldier.weight;
        this.color = buldier.color;
        this.productCount = buldier.productCount;
    }

    public static class Buldier {
        private long id;
        private String produktName;
        private float price;
        private float weight;
        private String color;
        private int productCount;

        public Buldier() { }

        public Buldier setId(long id) {
            this.id = id;
            return this;
        }

        public Buldier setProduktName(String produktName) {
            this.produktName = produktName;
            return this;
        }

        public Buldier setPrice(float price) {
            this.price = price;
            return this;
        }

        public Buldier setWeight(float weight) {
            this.weight = weight;
            return this;
        }

        public Buldier setColor(String color) {
            this.color = color;
            return this;
        }

        public Buldier setProductCount(int productCount) {
            this.productCount = productCount;
            return this;
        }

        public Product bulid() {
            return new Product(this);
        }
    }

    public long getId() {
        return id;
    }

    public String getProduktName() {
        return produktName;
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
        return "Product "
                + "Id='" + id + '\''
                + ", Name='" + produktName + '\''
                + ", Stock='" + productCount + '\''
                + ", Price='" + price + '\'';

    }
}
