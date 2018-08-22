package entity;

public class Main {
    public static void main(String[] args) {

        Boots boots = (Boots) new Boots.BootsBuldier()
                .setSizeBoots(43)
                .setIsNaturalSkin(true)
                .setId(1)
                .setProduktName("Kozaki")
                .setPrice(12.6f)
                .setWeight(11.12f)
                .setColor("red")
                .setProductCount(16)
                .bulid();

        System.out.println(boots.getPrice());
        System.out.println(boots.toString());

        Cloth cloth = (Cloth) new Cloth.ClothBuldier()
                .setSizeCloth("L")
                .setMaterial("L")
                .setId(1)
                .setProduktName("Kozaki")
                .setPrice(12.6f)
                .setWeight(11.12f)
                .setColor("red")
                .setProductCount(16)
                .bulid();

        System.out.println(cloth.toString());
    }
}
