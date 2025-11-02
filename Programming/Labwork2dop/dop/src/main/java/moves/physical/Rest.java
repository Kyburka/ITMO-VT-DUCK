package moves.physical;


import ru.ifmo.se.pokemon.*;

public class Rest extends PhysicalMove {
    public Rest() {
        super(Type.PSYCHIC, 0.0, 0.0);
    }

    @Override
    protected void applySelfEffects(Pokemon ally) {
        ally.setCondition(new Effect().condition(Status.SLEEP).turns(2));
        ally.setMod(Stat.HP, -(int)ally.getHP());
    }

    @Override
    protected String describe() {
        return "Использует физическую атаку Rest";
    }
}
