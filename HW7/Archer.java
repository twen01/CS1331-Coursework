//I worked on the homework assignment alone, using only course materials.

/**
 * represents archers in the army.
 *
 * @author Thomas Wen
 * @version 1
 */
public class Archer extends Troop implements Treatable {
    private String hairColor;

    /**
     * 4-arg constructor.
     *
     * @param name the name
     * @param experienceLevel the experience level
     * @param health the health
     * @param hairColor the hair color
     */
    public Archer(String name, int experienceLevel, int health, String hairColor) {
        super(name, experienceLevel, health);
        this.hairColor = hairColor;
    }

    /**
     * 1-arg constructor.
     *
     * @param hairColor the hair color
     */
    public Archer(String hairColor) {
        super("Sally", 10, 15);
        this.hairColor = hairColor;
    }

    /**
     * get hair color.
     *
     * @return the hair color
     */
    public String getHairColor() {
        return hairColor;
    }

    /**
     * set hair color.
     *
     * @param hairColor the hair color
     */
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * bruh its just the same.
     *
     * @param t the troop
     */
    public void trainWith(Troop t) {
        if (!(getHealth() < 5 || getHealth() == 100) && (t instanceof Barbarian || t instanceof Archer)
                && !(getExperienceLevel() == 50)) {
            if (t instanceof Archer) {
                Archer a = (Archer) t;
                if (getHairColor().equals(a.getHairColor())) {
                    setExperienceLevel(getExperienceLevel() + 4);
                    t.setExperienceLevel(t.getExperienceLevel() + 4);
                    System.out.println("I like training with other archers with the same hair color as me");
                } else {
                    setExperienceLevel(getExperienceLevel() + 2);
                    t.setExperienceLevel(t.getExperienceLevel() + 2);
                    System.out.println("Oof! I prefer training with other archers with the same hair color as me");
                }
                setHealth(getHealth() - 5);
                t.setHealth(t.getHealth() - 5);
            }
            if (t instanceof Barbarian) {
                setHealth(getHealth() - 10);
                System.out.println("Gross. Go away " + t.getName() + "! I hate training with Barbarians!");
            }
        }
    }

    /**
     * increases health by 3.
     */
    public void treat() {
        setHealth(getHealth() + 3);
    }

    /**
     * health less than 80?
     *
     * @return boolean
     */
    public boolean needsTreatment() {
        return getHealth() < 80;
    }

    /**
     * tostring method.
     *
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() + ". I am an archer with " + getHairColor() + " hair";
    }

    /**
     * name, experience, health, haircolor.
     *
     * @param o the object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Archer)) {
            return false;
        }

        Archer a = (Archer) o;
        return super.equals(a) && getHairColor().equals(a.getHairColor());
    }
}
