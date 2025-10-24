package moves.special;

import ru.ifmo.se.pokemon.*;

public class Scald extends SpecialMove {
    public Scald() {
        super(Type.WATER, 80.0, 100.0);
    }
    @Override
    protected void applyOppEffects(Pokemon enemy)  {
        if (Math.random()<=0.3) {
            Effect.burn(enemy);
        }
    }
    @Override
    protected String describe() {
        return "Использует специальную атаку Scald";
    }
}
