package Head_First.Creational_Patterns.Singleton;

/**
 * Thread-safe Singleton using double-checked locking.
 *
 * The volatile keyword prevents instruction reordering so that
 * a half-constructed instance is never returned to another thread.
 */
public class Singleton {

    private static volatile Singleton instance;

    private String state; // some per-instance state to make the demo tangible

    private Singleton() {
        state = "initialized";
        System.out.println("Singleton instance created.");
    }

    public static Singleton getInstance() {
        if (instance == null) { // first check (no lock)
            synchronized (Singleton.class) {
                if (instance == null) { // second check (with lock)
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
