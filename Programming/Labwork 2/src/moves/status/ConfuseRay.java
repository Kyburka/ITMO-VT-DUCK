package moves.status;

import ru.ifmo.se.pokemon.*;

public class ConfuseRay extends StatusMove {
    public ConfuseRay() {
        super(Type.GHOST, 0.0, 100.0);
    }

    @Override
    protected void applyOppEffects(Pokemon enemy) {
        enemy.confuse();
    }

    @Override
    protected String describe() {
        return "Использует статус-действие Confuse Ray";
    }
}
