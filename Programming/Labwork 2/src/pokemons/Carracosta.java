package pokemons;

import moves.physical.*;
import moves.status.*;
import moves.special.*;
import ru.ifmo.se.pokemon.*;

public class Carracosta extends Pokemon {
    private int baseHealthPoints;
    private int baseAttack;
    private int baseDefence;
    private int baseSpecialAttack;
    private int baseSpecialDefence;
    private int baseSpeed;

    public Carracosta(String name, int level) {
        super(name, level);
        setType(Type.WATER, Type.ROCK);
        baseHealthPoints = 74;
        baseAttack = 108;
        baseDefence = 133;
        baseSpecialAttack = 83;
        baseSpecialDefence = 65;
        baseSpeed = 32;
        setStats(baseHealthPoints, baseAttack, baseDefence, baseSpecialAttack, baseSpecialDefence, baseSpeed);
        setMove(new Scald(), new Confide(), new AquaTail(), new FocusBlast());
    }
}
