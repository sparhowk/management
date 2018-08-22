package entity;

public class Boots extends Product {
    private int size;
    private boolean isNaturalSkin;

    public Boots(BootsBuldier buldier) {
        super(buldier);
        this.size = buldier.size;
        this.isNaturalSkin = buldier.isNaturalSkin;
    }

    public static class BootsBuldier extends Product.Buldier {
        private int size;
        private boolean isNaturalSkin;

        public BootsBuldier() { }

        public BootsBuldier setSizeBoots(int size) {
            this.size = size;
            return this;
        }

        public BootsBuldier setIsNaturalSkin(boolean isNaturalSkin) {
            this.isNaturalSkin = isNaturalSkin;
            return this;
        }

        public Boots bulid() {
             return new Boots(this);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isNaturalSkin() {
        return isNaturalSkin;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", size=" + size
                + ", NaturalSkin=" + isNaturalSkin;
    }
}
