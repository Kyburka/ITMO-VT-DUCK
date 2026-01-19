package Classes;
import Interfaces.CanArrest;
public class Policeman extends Character implements CanArrest {
    public Policeman(String name, String gender) {
        super(name, gender);
        setClothing("Полицейская форма, каска и дубинка");
    }
}
