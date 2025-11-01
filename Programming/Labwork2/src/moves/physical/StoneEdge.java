package moves.physical;

import ru.ifmo.se.pokemon.*;

public class StoneEdge extends PhysicalMove {
    public StoneEdge() {
        super(Type.ROCK, 100.0, 80.0);
    }
    @Override
    protected double calcCriticalHit (Pokemon ally, Pokemon enemy) {
        if (3 * ally.getStat(Stat.SPEED) / 512.0 > Math.random()) {
            return 2.0;
        }
        else {
            return 1.0;
        }
    }
    @Override
    protected String describe() {
        return "Использует физическую атаку StoneEdge";
    }
}
