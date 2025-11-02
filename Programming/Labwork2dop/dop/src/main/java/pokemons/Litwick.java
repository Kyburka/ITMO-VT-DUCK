package pokemons;

import moves.physical.Rest;
import moves.status.ConfuseRay;
import ru.ifmo.se.pokemon.*;

public class Litwick extends Pokemon {
    private int baseHealthPoints;
    private int baseAttack;
    private int baseDefence;
    private int baseSpecialAttack;
    private int baseSpecialDefence;
    private int baseSpeed;

    public Litwick(String name, int level) {
        super(name, level);
        setType(Type.GHOST, Type.FIRE);
        baseHealthPoints = 50;
        baseAttack = 30;
        baseDefence = 55;
        baseSpecialAttack = 65;
        baseSpecialDefence = 55;
        baseSpeed = 20;
        setStats(baseHealthPoints, baseAttack, baseDefence, baseSpecialAttack, baseSpecialDefence, baseSpeed);
        setMove(new ConfuseRay(), new Rest());

    }
}
