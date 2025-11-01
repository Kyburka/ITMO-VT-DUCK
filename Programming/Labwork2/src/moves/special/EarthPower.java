package moves.special;

import ru.ifmo.se.pokemon.*;

public class EarthPower extends SpecialMove {
    public EarthPower() {
        super(Type.GROUND, 90.0, 100.0);
    }
    @Override
    protected void applyOppEffects(Pokemon enemy) {
        if (Math.random() <= 0.1) {
            enemy.setMod(Stat.SPECIAL_DEFENSE, -1);
        }
    }
    @Override
    protected String describe() {
        return "Использует специальную атаку Earth Power";
    }
}
