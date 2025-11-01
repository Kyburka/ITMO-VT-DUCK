package moves.special;

import ru.ifmo.se.pokemon.*;

public class DarkPulse extends SpecialMove {
    public DarkPulse() {
        super(Type.DARK, 80.0, 100.0);
    }
    @Override
    protected void applyOppEffects(Pokemon enemy) {
        if (Math.random() <= 0.2) {
            Effect.flinch(enemy);
        }
    }
    @Override
    protected String describe() {
        return "Использует специальную атаку Dark Pulse";
    }
}
