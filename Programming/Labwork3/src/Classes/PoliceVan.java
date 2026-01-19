package Classes;
import Interfaces.Vehicle;
public class PoliceVan extends Location implements Vehicle {
    private Location currentlocation;
    public PoliceVan(Location location) {
        super("Полицейский фургон");
        this.currentlocation = location;
    }
    public void drive(Location location) {
        System.out.println(this.getName() + " едет из " + this.currentlocation.getName() + " в " + location.getName());
        this.currentlocation = location;
        System.out.println(this.getName() + " приехал в " + this.currentlocation.getName());
    }

    public Location getCurrentlocation() {
        return currentlocation;
    }
}
