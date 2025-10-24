import ru.ifmo.se.pokemon.*;
import pokemons.*;
import java.util.*;
import java.util.stream.Gatherer;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        Scanner in = new Scanner(System.in);
        int counter = 1;
        String input = "";
        Pokemon[] db = new Pokemon[6];
        while (true) {
            input = in.nextLine();
            if (input.equals("exit")) {
                break;
            }
            String[] parts = input.split("\\s+");
            switch (parts[0]) {
                case "help":
                    System.out.printf("""  
                            Вот список доступных команд:
                            newPokemon (Один из шести готовых названий покемонов на английском) (Имя) (Уровень) - создать 1 из 6 готовых типов покемонов
                            newCustomPokemon (Имя) (Уровень) (Базовое ХП) (Базовая Атака) (Базовая Защита) (Базовая Специальная Атака) (Базовая Специальная Защита) (Базовая Скорость) (Все действия покемона через запятую) (Типы через запятую) - создать собственного покемона
                            addToAlly (Номер покемона) - добавить указанного покемона к союзникам
                            addToEnemy (Название переменной) - добавить указанного покемона к врагам
                            startBattle - начать бой
                            exit - закончить выполнение программы
                            """);
                    break;
                case "newPokemon":
                    String Type = parts[1];
                    String Name = parts[2];
                    int level = Integer.parseInt(parts[3]);
                    db[counter-1] = pokemonCreation(Type, Name, level);
                    counter++;
                    break;
                case "newCustomPokemon":
                    String NameCustom = parts[1];
                    int levelCustom = Integer.parseInt(parts[2]);
                    int baseHealthPoints = Integer.parseInt(parts[3]);
                    int baseAttack = Integer.parseInt(parts[4]);
                    int baseDefence = Integer.parseInt(parts[5]);
                    int baseSpecialAttack = Integer.parseInt(parts[6]);
                    int baseSpecialDefence = Integer.parseInt(parts[7]);
                    int baseSpeed = Integer.parseInt(parts[8]);
                    String moves = parts[9];
                    String types = parts[10];
                    db[counter-1] = new Constructor(NameCustom, levelCustom, baseHealthPoints, baseAttack, baseDefence, baseSpecialAttack, baseSpecialDefence, baseSpeed, moves, types);
                    counter++;
                    break;
                case "addToAlly":
                    int cntAlly = Integer.parseInt(parts[1]);
                    b.addAlly(db[cntAlly-1]);
                    break;
                case "addToEnemy":
                    int cntEnemy = Integer.parseInt(parts[1]);
                    b.addFoe(db[cntEnemy-1]);
                    break;
                case "startBattle":
                    b.go();
                    break;
            }
            //String name, int level, int baseHealthPoints, int baseAttack, int baseDefence,
            //int baseSpecialAttack, int baseSpecialDefence, int baseSpeed, String moves,
            //        String types
        }
    }
    private static Pokemon pokemonCreation (String Type, String Name, int level) {
        switch (Type) {
            case "Carracosta":
                return new Carracosta(Name, level);
            case "Chandelure":
                return new Chandelure(Name, level);
            case "Heatran":
                return new Heatran(Name, level);
            case "Lampent":
                return new Lampent(Name, level);
            case "Litwick":
                return new Litwick(Name, level);
            case "Tirtouga":
                return new Tirtouga(Name, level);
            default:
                return new Pokemon(Name, level);
        }
    }
}