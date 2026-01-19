package Interfaces;
public interface Vehicle {
    String getName();
    default void drive() {
        System.out.println(getName() + " едет до пункта назначения.");
        System.out.println(this.getName() + " приехал в пункт назначения");
    }
}
