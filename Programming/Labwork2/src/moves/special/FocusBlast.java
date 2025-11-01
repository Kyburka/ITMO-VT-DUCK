package moves.special;

import ru.ifmo.se.pokemon.*;

public class FocusBlast extends SpecialMove {
    public FocusBlast() {
        super(Type.FIGHTING,120.0,70.0);
    }
    @Override
    protected void applyOppEffects(Pokemon enemy) {
        if (Math.random() <= 0.1) {
            enemy.setMod(Stat.SPECIAL_DEFENSE, -1);
        }
    }
    @Override
    protected String describe() {
        return "Использует специальную атаку Focus Blast";
    }
}
