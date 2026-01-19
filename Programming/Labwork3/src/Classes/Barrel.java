package Classes;

public class Barrel extends Item{
    public Barrel(Location location, String description) {
        super("бочка", location, description);
    }
    public boolean isEmpty() {
        return this.getDescription().contains("пустая");
    }
}
