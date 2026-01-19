package Interfaces;
import Classes.Character;

public interface CanSoothe {
    String getName();
    default void soothe(Character target) {
        System.out.println(getName() + " успокаивает " + target.getName());
    }
}
