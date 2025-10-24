package moves.special;

import ru.ifmo.se.pokemon.*;

public class Ember extends SpecialMove {
    public Ember() {
        super(Type.FIRE, 40.0, 100.0);
    }
    @Override
    protected void applyOppEffects(Pokemon enemy) {
        if (Math.random() <= 0.1) {
            Effect.burn(enemy);
        }
    }
    @Override
    protected String describe() {
        return "Использует специальную атаку Ember";
    }
}
