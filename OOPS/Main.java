package OOPS;

class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        Item item = new Item("table", 20);
        Fruits fruit = new Fruits("Apples", 30, "Kashmir");
        Weapon weapon = new Weapon("Knife", 1, 25, "Meele");

        inventory.addItem(item);
        inventory.addItem(fruit);
        inventory.addItem(weapon);
        inventory.addItem("AK47", 10, 100, "Automatic Rifle");
        inventory.addItem("Apples", 60, "Shimla");

        inventory.displayInventory();
    }
}
