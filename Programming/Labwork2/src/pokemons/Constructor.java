package pokemons;

import moves.status.*;
import moves.physical.*;
import moves.special.*;
import ru.ifmo.se.pokemon.*;
import java.util.*;

public class Constructor extends Pokemon {
    private int baseHealthPoints;
    private int baseAttack;
    private int baseDefence;
    private int baseSpecialAttack;
    private int baseSpecialDefence;
    private int baseSpeed;

    public Constructor(String name, int level, int baseHealthPoints, int baseAttack, int baseDefence,
                       int baseSpecialAttack, int baseSpecialDefence, int baseSpeed, String moves,
                       String types) {
        super(name, level);
        setStats(baseHealthPoints, baseAttack, baseDefence, baseSpecialAttack, baseSpecialDefence, baseSpeed);
        String[] movesParts = moves.split(",");
        String[] typesParts = types.split(",");
        if (typesParts.length == 2) {
            Type typeFirst = Type.valueOf(typesParts[0]);
            Type typeSecond = Type.valueOf(typesParts[1]);
            setType(typeFirst, typeSecond);
        }
        else if (typesParts.length == 1) {
            setType(Type.valueOf(typesParts[0]));
        }
        Set<String> set = new HashSet<>();
        for (String part : movesParts) {
            set.add(part);
        }
        for (String part : set) {
            switch (part) {
                case "AquaTail":
                    addMove(new AquaTail());
                    break;
                case "Rest":
                    addMove(new Rest());
                    break;
                case "StoneEdge":
                    addMove(new StoneEdge());
                    break;
                case "DarkPulse":
                    addMove(new DarkPulse());
                    break;
                case "EarthPower":
                    addMove(new EarthPower());
                    break;
                case "Ember":
                    addMove(new Ember());
                    break;
                case "FocusBlast":
                    addMove(new FocusBlast());
                    break;
                case "Scald":
                    addMove(new Scald());
                    break;
                case "Confide":
                    addMove(new Confide());
                    break;
                case "ConfuseRay":
                    addMove(new ConfuseRay());
                    break;
                case "Swagger":
                    addMove(new Swagger());
                    break;
            }
        }
    }
}
