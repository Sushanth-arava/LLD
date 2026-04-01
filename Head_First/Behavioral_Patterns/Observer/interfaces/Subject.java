package Head_First.Behavioral_Patterns.Observer.interfaces;

public interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
