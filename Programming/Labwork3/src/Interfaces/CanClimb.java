package Interfaces;

public interface CanClimb {
    String getName();
    default void climb(Object object) {
        System.out.println(getName() + " залез на " + object);
    }
}
