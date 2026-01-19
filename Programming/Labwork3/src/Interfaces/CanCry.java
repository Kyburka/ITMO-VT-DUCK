package Interfaces;

public interface CanCry {
    String getName();
    default void cry() {
        System.out.println(getName() + " плачет.");
    }
}
