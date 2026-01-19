package Classes;

import Enums.BowlType;

public class Bowl extends Item {
    private BowlType type;
    public Bowl(Location location, String food, BowlType type) {
        super("тарелка", location, food);
        this.type = type;
    }
}
