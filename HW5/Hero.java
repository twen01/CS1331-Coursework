/**
 * Represents a hero with name, health, and damage capability.
 *
 * @author Thomas Wen
 * @version 1.0
 */
public abstract class Hero extends Entity {
    private int damage;

    /**
     * Constructs a hero with given attributes.
     *
     * @param name   the hero's name
     * @param health the hero's health
     * @param damage the damage the hero deals
     */
    public Hero(String name, int health, int damage) {
        super(name, health);
        this.damage = damage < 0 ? 0 : damage;
    }

    /**
     * Constructs a hero with default damage of 1.
     *
     * @param name   the hero's name
     * @param health the hero's health
     */
    public Hero(String name, int health) {
        this(name, health, 1);
    }

    /**
     * Gets the damage the hero deals.
     *
     * @return the hero's damage value
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Increases the damage the hero deals if alive.
     *
     * @param n the amount to increase damage by
     */
    protected void increaseDamage(int n) {
        damage = isAlive() ? damage + n : damage;
    }

    /**
     * Trains the hero at a training ground.
     *
     * @param t the training ground
     */
    public abstract void train(TrainingGround t);

    /**
     * Checks if the hero has armor equipped.
     *
     * @return true if hero has armor, false otherwise
     */
    public abstract boolean hasArmor();

    /**
     * Attacks an enemy if the hero is alive.
     *
     * @param e the enemy to attack
     */
    public void attack(Enemy e) {
        if (isAlive()) {
            e.takeDamage(damage);
        }
    }

    /**
     * Returns a string representation of the hero.
     *
     * @return string describing the hero's status
     */
    public String toString() {
        return isAlive() ? super.toString() + ". I deal " + damage + " damage" : super.toString();
    }

    /**
     * Checks if this hero is equal to another object.
     *
     * @param o the object to compare
     * @return true if equal, false otherwise
     */
    public boolean equals(Object o) {
        if (!(o instanceof Hero)) {
            return false;
        }
        Hero h = (Hero) o;
        return super.equals(h) && damage == h.getDamage();
    }
}
