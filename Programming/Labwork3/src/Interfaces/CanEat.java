package Interfaces;

public interface CanEat {
    String getName();
    default void eat(Object food) {
        System.out.println(getName() + " съел " + food);
    }
}
