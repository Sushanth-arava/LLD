package OOPS;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<OOPS.Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addItem(String name, int quantity, String type) {
        items.add(new Fruits(name, quantity, type));
    }

    public void addItem(String name, int quantity, int damage, String type) {
        items.add(new Weapon(name, quantity, damage, type));
    }

    public void displayInventory() {
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }
}
