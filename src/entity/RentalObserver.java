package entity;

public interface RentalObserver {
    public void addObserver(Tenant tenant);
    public void removeObserver(Tenant tenant);
    public void notifyObservers();
}
