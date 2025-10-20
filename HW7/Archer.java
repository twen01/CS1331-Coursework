/**
 * represents archers in the army
 * 
 * @author Thomas Wen
 * @version 1
 */
public class Archer extends Troop implements Treatable {
    private String hairColor;

    /**
     * 4-arg constructor
     * 
     * @param name
     * @param experienceLevel
     * @param health
     * @param hairColor
     */
    public Archer(String name, int experienceLevel, int health, String hairColor) {
        super(name, experienceLevel, health);
        this.hairColor = hairColor;
    }

    /**
     * 1-arg constructor 
     * 
     * @param hairColor
     */
    public Archer(String hairColor) {
        super("Sally", 10, 15);
        this.hairColor = hairColor;
    }
}
