//I worked on the homework assignment alone, using only course materials.

/**
 * Represents an entity in the world with a name and health.
 *
 * @author Thomas Wen
 * @version 1.0
 */
public abstract class Entity {
    private String name;
    private int health;

    /**
     * Constructs an entity with the given name and health.
     *
     * @param name   the name of the entity
     * @param health the health of the entity
     */

    public Entity(String name, int health) {
        this.name = name;
        this.health = health;

        if (health < 0) {
            this.health = 0;
        }
    }

    /**
     * Gets the name of the entity.
     *
     * @return the entity's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the health of the entity.
     *
     * @return the entity's health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the name of the entity.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the health of the entity.
     *
     * @param health the new health value
     */
    private void setHealth(int health) {
        this.health = (health < 0) ? 0 : health;
    }

    /**
     * Checks if the entity is alive.
     *
     * @return true if health is greater than 0, false otherwise
     */
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * Reduces the entity's health by the given damage amount.
     *
     * @param damage the amount of damage to take
     */
    public void takeDamage(int damage) {
        setHealth(health - damage);
    }

    /**
     * Increases the entity's health if alive and amount is positive.
     *
     * @param numHeal the amount of health to restore
     */
    public void heal(int numHeal) {
        if (numHeal > 0 && isAlive()) {
            setHealth(health + numHeal);
        }
    }

    /**
     * Returns a string representation of the entity.
     *
     * @return string describing the entity's status
     */
    public String toString() {
        return isAlive() ? "I am " + name + ", and I have " + health + " health" : "I was " + name;
    }

    /**
     * Checks if this entity is equal to another object.
     *
     * @param o the object to compare
     * @return true if equal, false otherwise
     */
    public boolean equals(Object o) {
        if (!(o instanceof Entity)) {
            return false;
        }
        Entity e = (Entity) o;
        return name.equals(e.getName()) && health == e.getHealth();
    }
}
