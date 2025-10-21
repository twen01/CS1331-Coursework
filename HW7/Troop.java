/**
 * Abstract Class that represents a tropp in the army.
 *
 * @author Thomas Wen
 * @version 1
 */
public abstract class Troop {
    private String name;
    private int experienceLevel;
    private int health;

    /**
     * Sets instance variables.
     *
     * @param name the name
     * @param experienceLevel the experience level
     * @param health the health
     */
    public Troop(String name, int experienceLevel, int health) {
        setName(name);
        setExperienceLevel(experienceLevel);
        setHealth(health);
    }

    /**
     * Abstract method to have a troop train with another to gain experience.
     *
     * @param p the troop
     */
    public abstract void trainWith(Troop p);

    /**
     * Returns the below.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "My name is " + name + ", my experience level is " + experienceLevel + ", and my health is " + health;
    }

    /**
     * Checks if two Troops have the same instance variable values.
     *
     * @param o the object to compare
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Troop)) {
            return false;
        }
        Troop t = (Troop) o;
        return name.equals(t.name) && experienceLevel == t.experienceLevel && health == t.health;
    }

    /**
     * Return name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Return experience level.
     *
     * @return the experience level
     */
    public int getExperienceLevel() {
        return experienceLevel;
    }

    /**
     * Return health.
     *
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Set name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set experience level.
     *
     * @param experienceLevel the experience level
     */
    public void setExperienceLevel(int experienceLevel) {
        if (experienceLevel < 1) {
            this.experienceLevel = 1;
        } else if (experienceLevel > 50) {
            this.experienceLevel = 50;
        } else {
            this.experienceLevel = experienceLevel;
        }
    }

    /**
     * Set health.
     *
     * @param health the health
     */
    public void setHealth(int health) {
        if (health < 1) {
            this.health = 1;
        } else if (health > 100) {
            this.health = 100;
        } else {
            this.health = health;
        }
    }
}
