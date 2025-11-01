package pokemons;

import moves.physical.*;
import moves.special.*;
import moves.status.*;
import ru.ifmo.se.pokemon.*;

public class Heatran extends Pokemon {
    private int baseHealthPoints;
    private int baseAttack;
    private int baseDefence;
    private int baseSpecialAttack;
    private int baseSpecialDefence;
    private int baseSpeed;

    public Heatran(String name, int level) {
        super(name, level);
        setType(Type.FIRE, Type.STEEL);
        baseHealthPoints = 91;
        baseAttack = 90;
        baseDefence = 106;
        baseSpecialAttack = 130;
        baseSpecialDefence = 106;
        baseSpeed = 77;
        setStats(baseHealthPoints, baseAttack, baseDefence, baseSpecialAttack, baseSpecialDefence, baseSpeed);
        setMove(new StoneEdge(), new DarkPulse(), new EarthPower(), new Swagger());
    }
}
