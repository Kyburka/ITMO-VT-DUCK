package pokemons;

import moves.physical.*;
import moves.special.*;
import moves.status.*;
import ru.ifmo.se.pokemon.*;

public class Tirtouga extends Pokemon {
    private int baseHealthPoints;
    private int baseAttack;
    private int baseDefence;
    private int baseSpecialAttack;
    private int baseSpecialDefence;
    private int baseSpeed;

    public Tirtouga(String name, int level) {
        super(name, level);
        setType(Type.WATER, Type.ROCK);
        baseHealthPoints = 54;
        baseAttack = 78;
        baseDefence = 103;
        baseSpecialAttack = 53;
        baseSpecialDefence = 45;
        baseSpeed = 22;
        setStats(baseHealthPoints, baseAttack, baseDefence, baseSpecialAttack, baseSpecialDefence, baseSpeed);
        setMove(new Scald(), new Confide(), new AquaTail());
    }
}
