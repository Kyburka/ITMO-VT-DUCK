package Classes;

public abstract class Item {
    protected String name;
    private Location location;
    private String description;
    public Item(String name, Location location, String description) {
        this.name = name;
        this.location = location;
        this.description = description;
    }
    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
