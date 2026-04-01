package Head_First.Creational_Patterns.Singleton;

public class Main {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println("Same instance? " + (s1 == s2)); // true

        s1.setState("updated via s1");
        System.out.println("State via s2: " + s2.getState()); // updated via s1
    }
}