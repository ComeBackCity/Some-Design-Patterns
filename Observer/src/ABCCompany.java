import java.util.ArrayList;

public class ABCCompany implements Subject {

    private ArrayList<Observer> observers = new ArrayList<Observer>();
    serverState currentState;

    public ABCCompany() {
        this.currentState = new serverState(0);
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregisterObserver(Observer o) {
        int i=-1;
        i = observers.indexOf(o);
        if(i>=0)
            observers.remove(i);

    }

    @Override
    public void notifyObserver() {
        for (Observer observer: observers)
            observer.update(currentState);
    }

    public serverState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(serverState currentState) {
        this.currentState = currentState;
        notifyObserver();
    }
}
