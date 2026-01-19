package Classes;
import java.util.Objects;
public abstract class Character {
    private String name;
    private String gender;
    private String clothing;
    private Boolean arrested;
    private Location currentlocation;
    public Character(String name, String gender) {
        this.name = name;
        this.gender = gender;
        this.clothing = "Типичная одежда";
        this.arrested = false;
    }
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public String getClothing() {
        return clothing;
    }
    public Location getCurrentLocation() {
        return currentlocation;
    }
    public void setCurrentLocation(Location newLocation) {
        this.currentlocation = newLocation;
        System.out.println(this.getName() + " переместился в локацию " + newLocation.getName());
    }
    public void setClothing(String clothing) {
        this.clothing = clothing;
    }

    public boolean isArrested() {
        return arrested;
    }

    public void setArrested(boolean arrested) {
        this.arrested = arrested;
        if(arrested) {
            System.out.println(name + " был(а) задержан.");
        }
        else {
            System.out.println(name + " выпущен на свободу.");
        }
    }

    public void say(String phrase) {
        System.out.println(name + " сказал:\"" + phrase + "\".");
    }

    public void bring(Object item, Character target) {
        System.out.println(this.name + " принес(-ла) " + item + " для " + target.getName());
    }
}
