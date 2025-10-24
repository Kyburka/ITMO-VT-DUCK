package moves.status;

import ru.ifmo.se.pokemon.*;

public class Confide extends StatusMove {
    public Confide() {
        super(Type.NORMAL, 0.0, 0.0);
    }
    @Override
    protected void applyOppEffects(Pokemon enemy)  {
        enemy.setMod(Stat.SPECIAL_ATTACK, -1);
    }
    @Override
    protected String describe() {
        return "Использует статус-действие Confide";
    }
}
