package pokemons;

import moves.physical.Rest;
import moves.special.Ember;
import moves.status.*;
import ru.ifmo.se.pokemon.*;

public class Chandelure extends Pokemon {
    private int baseHealthPoints;
    private int baseAttack;
    private int baseDefence;
    private int baseSpecialAttack;
    private int baseSpecialDefence;
    private int baseSpeed;

    public Chandelure(String name, int level) {
        super(name, level);
        setType(Type.GHOST, Type.FIRE);
        baseHealthPoints = 60;
        baseAttack = 55;
        baseDefence = 90;
        baseSpecialAttack = 145;
        baseSpecialDefence = 90;
        baseSpeed = 80;
        setStats(baseHealthPoints, baseAttack, baseDefence, baseSpecialAttack, baseSpecialDefence, baseSpeed);
        setMove(new ConfuseRay(), new Rest(), new Ember(), new Confide());
    }
}
