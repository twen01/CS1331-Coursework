/**
 * Abstract Class that represents a tropp in the army
 * 
 * @author Thomas Wen
 * @version 1
 */
public abstract class Troop {
    private String name;
    private int experienceLevel;
    private int health;

    /**
     * Sets instance variables
     * 
     * @param name
     * @param experienceLevel
     * @param health
     */
    public Troop(String name, int experienceLevel, int health) {
        setName(name);
        setExperienceLevel(experienceLevel);
        setHealth(health);
    }

    /**
     * Abstract method to have a troop train with another to gain experience
     * 
     * @param p
     */
    public abstract void trainWith(Troop p);

    /**
     * Returns the below
     */
    @Override
    public String toString() {
        return "My name is " + name + ", my experience level is " + experienceLevel + ", and my health is " + health;
    }

    /**
     * Checks if two Troops have the same instance variable values
     * 
     * @param o
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
     * Return name
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Return experience level
     * 
     * @return
     */
    public int getExperienceLevel() {
        return experienceLevel;
    }

    /**
     * Return health
     * 
     * @return
     */
    public int getHealth() {
        return health;
    }

    /**
     * Set name
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set experience level
     * 
     * @param experienceLevel
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
     * Set health
     * 
     * @param health
     */
    public void setHealth(int health) {
        if (this.health < 1) {
            this.health = 1;
        } else if (this.health > 50) {
            this.health = 50;
        } else {
            this.health = health;
        }
    }
}
