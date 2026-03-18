package atmin_v5;

import atmin_v4.Observer;
import atmin_v4.Subject;

import java.util.ArrayList;

public class TemperatureSensor implements Subject {
    private final ArrayList<Observer> observers = new ArrayList<>();
    private int curTemp;

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(curTemp);
        }
    }

    public void setTemp(int temp) {
        this.curTemp = temp;
        System.out.println("\nCảm biến: " + curTemp + "°C");
        notifyObservers();
    }
}
