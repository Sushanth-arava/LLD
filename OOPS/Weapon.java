package OOPS;

public class Weapon extends Item {
    private int damage;
    private String type;

    public Weapon(String name, int quantity, int damage, String type) {
        super(name, quantity);
        this.type = type;
        this.damage = damage;

    }

    public int getDamage() {
        return damage;

    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Item: " + getName() + ", Quantity: " + getQuantity() + ", Weapon type: " + getType();

    }
}