package entity;

public class Cloth extends Product{
    private String size;
    private String material;

    public Cloth(ClothBuldier buldier){
        super(buldier);
        this.size = buldier.size;
        this.material = buldier.material;
    }

    public static class ClothBuldier extends Product.Buldier {
        private String size;
        private String material;

        public ClothBuldier() {}

        public ClothBuldier setSizeCloth(String size) {
            this.size = size;
            return this;
        }

        public ClothBuldier setMaterial(String material) {
            this.material = material;
            return this;
        }

        public Cloth bulid() {
            return new Cloth(this);
        }
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", size=" + size
                + ", Material=" + material;
    }
}
