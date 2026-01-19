package Interfaces;
import Classes.Character;

public interface CanArrest {
    String getName();
    default void arrest(Character target) {
        System.out.println(this.getName() + " задерживает " + target.getName());
        target.setArrested(true);
    }
}
