import org.jline.keymap.KeyMap;
import ru.ifmo.se.pokemon.*;
import pokemons.*;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.DefaultParser;
import org.jline.reader.*;
import org.jline.reader.impl.*;
import org.jline.reader.impl.completer.*;
import java.util.*;

public class Main {
    private static Map<String, Runnable> commands = new HashMap<>();
    private static List<Pokemon> pokemonDB = new ArrayList<>();
    private static final String[] movesDataBase = {"AquaTail","Rest","StoneEdge","DarkPulse","EarthPower","Ember",
            "FocusBlast","Scald","Confide","ConfuseRay","Swagger"};
    private static final String[] typesDataBase = {"Carracosta","Chandelure","Heatran","Lampent","Litwick","Tirtouga"};
    static boolean flag = true;
    static Battle b = new Battle();
    public static void main(String[] args) {
        try {
            Terminal terminal = TerminalBuilder.builder()
                    .jna(false)
                    .jansi(false)
                    .dumb(true)
                    .encoding("UTF-8")
                    .build();
            Completer completer = new ArgumentCompleter(new StringsCompleter("addToEnemy", "addToAlly", "help", "helpTypes", "helpMoves", "exit", "newPokemon", "newCustomPokemon", "startBattle"));
            LineReader reader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .completer(completer)
                    .parser(new DefaultParser())
                    .option(LineReader.Option.AUTO_FRESH_LINE, true)
                    .option(LineReader.Option.AUTO_LIST, true)    // Показывать список при двойном Tab
                    .option(LineReader.Option.AUTO_MENU, true)    // Показывать меню при Tab
                    .option(LineReader.Option.CASE_INSENSITIVE, true)
                    .build();
            String input = "";
            setupCommands();
            while (flag || input.equals("exit")) {
                input = reader.readLine("poke>");
                input = input.trim();
                if (input.isEmpty()) {
                    continue;
                }
                processCommand(input);
            }
            /*
            int size = Integer.parseInt(input);
            Pokemon[] db = new Pokemon[size];
            while (true) {
                input = in.nextLine();
                if (input.equals("exit") || !flag) {
                    break;
                }
                String[] parts = input.split("\\s+");
                switch (parts[0]) {
                    case "help":
                        System.out.printf("""  
                                Here is the list of available commands:
                                newPokemon (One of six ready-made Pokemon names in English) (Name) (Level) - create 1 of 6 ready-made Pokemon types
                                newCustomPokemon (Name) (Level) (Basic HP) (Basic Attack) (Basic Defense) (Basic Special Attack) (Basic Special Defense) (Basic Speed) (All Pokemon actions separated by commas) (Types separated by commas) - create your own Pokemon
                                addToAlly (Pokemon Number) - add the specified Pokemon to the allies
                                addToEnemy (Pokemon Number) - add the specified Pokemon to the enemies
                                startBattle - start the battle
                                showList - shows already created Pokemon
                                exit - end the program execution.
                                helpTypes - display all types of Pokemon that are in the program
                                helpMoves - display all Pokemon actions that are in the program
                                """);
                        break;
                    case "showList":
                        if (db.length == 0) {
                            System.out.println("Zero");
                        }
                        else {
                            for (int i = 0; i < size; i++) {
                                System.out.println(i+1 + " " + db[i]);
                            }
                        }
                        break;
                    case "helpTypes":
                        for (String type : typesDataBase) {
                            System.out.println(type);
                        }
                        break;
                    case "helpMoves":
                        for (String move : movesDataBase) {
                            System.out.println(move);
                        }
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
                        b1.addAlly(db[cntAlly-1]);
                        break;
                    case "addToEnemy":
                        int cntEnemy = Integer.parseInt(parts[1]);
                        b.addFoe(db[cntEnemy-1]);
                        b1.addFoe(db[cntEnemy-1]);
                        break;
                    case "startBattle":
                        b.go();b1.go();
                        flag = false;
                        break;
                }
            }*/
        } catch (Exception e) {
            e.printStackTrace();
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

    private static void setupCommands() {
        commands.put("help", () -> showHelp());
        commands.put("showList", () -> System.out.println("Список покемонов"));
        commands.put("helpTypes", () -> System.out.println("Список типов покемонов"));
        commands.put("helpMoves", () -> System.out.println("Список действий покемонов"));
        commands.put("newPokemon", () -> System.out.println("Добавление покемона"));
        commands.put("newCustomPokemon", () -> System.out.println("Добавление созданного покемона"));
        commands.put("addToAlly", () -> System.out.println("Добавляем к союзникам"));
        commands.put("addToEnemy", () -> System.out.println("Добавляем к врагам"));
        commands.put("startBattle", () -> System.out.println("Начало битвы"));
    }

    private static void processCommand(String command) {
        if (command.isEmpty())
            return;
        String[] parts = command.split("\\s+");
        String commandName = parts[0].toLowerCase();
        String[] args = Arrays.copyOfRange(parts, 1, parts.length);
        switch (commandName) {
            case "help":
                showHelp();
                break;
            case "showlist":
                if (pokemonDB.isEmpty()) {
                    System.out.println("Zero");
                }
                else {
                    int i = 0;
                    for (Pokemon pokemon : pokemonDB) {
                        System.out.println(i+1 + " " + pokemon);
                        i++;
                    }
                }
                break;
            case "helptypes":
                for (String type : typesDataBase) {
                    System.out.println(type);
                }
                break;
            case "helpmoves":
                for (String move : movesDataBase) {
                    System.out.println(move);
                }
                break;
                /*
                newPokemon (One of six ready-made Pokemon names in English) (Name) (Level) - create 1 of 6 ready-made Pokemon types
                                newCustomPokemon (Name) (Level) (Basic HP) (Basic Attack) (Basic Defense) (Basic Special Attack) (Basic Special Defense) (Basic Speed) (All Pokemon actions separated by commas) (Types separated by commas) - create your own Pokemon
                                addToAlly (Pokemon Number) - add the specified Pokemon to the allies
                                addToEnemy (Pokemon Number) - add the specified Pokemon to the enemies
                                startBattle - start the battle
                                showList - shows already created Pokemon
                                exit - end the program execution.
                                helpTypes - display all types of Pokemon that are in the program
                                helpMoves - display all Pokemon actions that are in the program
                 */
            case "newpokemon":
                if (parts.length == 1) {
                    System.out.println("Usage: newpokemon (One of six ready-made Pokemon names in English) (Name) (Level)");
                }
                else {
                    String Type = args[0];
                    String Name = args[1];
                    int level = Integer.parseInt(args[2]);
                    pokemonDB.add(pokemonCreation(Type, Name, level));
                }
                break;
            case "newcustompokemon":
                if (parts.length == 1) {
                    System.out.println("Usage: newCustomPokemon (Name) (Level) (Basic HP) (Basic Attack) (Basic Defense) (Basic Special Attack) (Basic Special Defense) (Basic Speed) (All Pokemon actions separated by commas) (Types separated by commas)");
                }
                else {
                    String NameCustom = args[0];
                    int levelCustom = Integer.parseInt(args[1]);
                    int baseHealthPoints = Integer.parseInt(args[2]);
                    int baseAttack = Integer.parseInt(args[3]);
                    int baseDefence = Integer.parseInt(args[4]);
                    int baseSpecialAttack = Integer.parseInt(args[5]);
                    int baseSpecialDefence = Integer.parseInt(args[6]);
                    int baseSpeed = Integer.parseInt(args[7]);
                    String moves = args[8];
                    String types = args[9];
                    pokemonDB.add(new Constructor(NameCustom, levelCustom, baseHealthPoints, baseAttack, baseDefence, baseSpecialAttack, baseSpecialDefence, baseSpeed, moves, types));
                }
                break;
            case "addtoally":
                if (parts.length == 1) {
                    System.out.println("Usage: addToAlly (Pokemon Number in list)");
                }
                else {
                    int cntAlly = Integer.parseInt(args[0]);
                    b.addAlly(pokemonDB.get(cntAlly - 1));
                }
                break;
            case "addtoenemy":
                if (parts.length == 1) {
                    System.out.println("Usage: addToEnemy (Pokemon Number in list)");
                }
                else {
                    int cntEnemy = Integer.parseInt(args[0]);
                    b.addFoe(pokemonDB.get(cntEnemy - 1));
                }
                break;
            case "startbattle":
                b.go();
                flag = false;
                break;
        }
    }

    private static void showHelp() {
        System.out.println("commands:");
        commands.keySet().forEach(cmd -> System.out.println(" - " + cmd));
    }
}