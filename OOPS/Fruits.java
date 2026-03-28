package OOPS;

public class Fruits extends Item {
    private String type;

    public Fruits(String name, int quantity, String type) {
        super(name, quantity);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Item: " + getName() + ", Quantity: " + getQuantity() + ", Fruit type: " + getType();

    }
}