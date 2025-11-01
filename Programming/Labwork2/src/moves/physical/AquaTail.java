package moves.physical;

import ru.ifmo.se.pokemon.*;

public class AquaTail extends PhysicalMove {
    public AquaTail() {
        super(Type.WATER,90.0,90.0);
    }
    @Override
    protected String describe() {
        return "Использует физическую атаку Aqua Tail";
    }
}
