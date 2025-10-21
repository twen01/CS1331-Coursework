/**
 * represents golems in army.
 *
 * @author Thomas Wen
 * @version 1
 */
public class Golem extends Troop {
    private int weight;

    /**
     * 4-arg constructor.
     *
     * @param name the name
     * @param experienceLevel the experience level
     * @param health the health
     * @param weight the weight
     */
    public Golem(String name, int experienceLevel, int health, int weight) {
        super(name, experienceLevel, health);
        this.weight = weight;
    }

    /**
     * 0-arg constructor.
     */
    public Golem() {
        super("Nelly", 19, 80);
        weight = 10;
    }

    /**
     * get weight.
     *
     * @return an int
     */
    public int getWeight() {
        return weight;
    }

    /**
     * set weight.
     *
     * @param weight the weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * lot of stuff.
     *
     * @param t the troop
     */
    public void trainWith(Troop t) {
        if (!(getHealth() < 15 || getHealth() == 100) && t instanceof Golem && getExperienceLevel() != 50) {
            setExperienceLevel(getExperienceLevel() + 3);
            t.setExperienceLevel(t.getExperienceLevel() + 3);
            setHealth(getHealth() - 12);
            t.setHealth(t.getHealth() - 12);
        }
    }

    /**
     * override tostring.
     *
     * @return a string
     */
    @Override
    public String toString() {
        return super.toString() + ". I am a golem that weighs " + weight + " tons";
    }

    /**
     * check if name, exp level, health, weight are equal.
     *
     * @param o the object
     * @return a boolean
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Golem)) {
            return false;
        }
        Golem g = (Golem) o;
        return super.equals(g) && getWeight() == g.getWeight();
    }
}
