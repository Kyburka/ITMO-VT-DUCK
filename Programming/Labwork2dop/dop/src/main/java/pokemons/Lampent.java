package pokemons;

import moves.physical.Rest;
import moves.special.Ember;
import moves.status.ConfuseRay;
import ru.ifmo.se.pokemon.*;

public class Lampent extends Pokemon {
    private int baseHealthPoints;
    private int baseAttack;
    private int baseDefence;
    private int baseSpecialAttack;
    private int baseSpecialDefence;
    private int baseSpeed;

    public Lampent(String name, int level) {
        super(name, level);
        setType(Type.GHOST, Type.FIRE);
        baseHealthPoints = 60;
        baseAttack = 40;
        baseDefence = 60;
        baseSpecialAttack = 95;
        baseSpecialDefence = 60;
        baseSpeed = 55;
        setStats(baseHealthPoints, baseAttack, baseDefence, baseSpecialAttack, baseSpecialDefence, baseSpeed);
        setMove(new ConfuseRay(), new Rest(), new Ember());
    }
}
