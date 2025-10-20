/**
 * Represents an archer hero with equippable armor.
 *
 * @author Thomas Wen
 * @version 1.0
 */
public class Archer extends Hero {
    private boolean hasArmorEquipped;

    /**
     * Constructs an archer with given attributes.
     *
     * @param name             the archer's name
     * @param health           the archer's health
     * @param damage           the damage the archer deals
     * @param hasArmorEquipped whether armor is equipped
     */
    public Archer(String name, int health, int damage, boolean hasArmorEquipped) {
        super(name, health, damage);
        this.hasArmorEquipped = hasArmorEquipped;
    }

    /**
     * Constructs an archer with default damage and no armor.
     *
     * @param name   the archer's name
     * @param health the archer's health
     */
    public Archer(String name, int health) {
        this(name, health, 4, false);
    }

    /**
     * Constructs an archer with default health, damage, and no armor.
     *
     * @param name the archer's name
     */
    public Archer(String name) {
        this(name, 20, 4, false);
    }

    /**
     * Equips armor if the archer is alive.
     */
    public void equipArmor() {
        hasArmorEquipped = isAlive() ? true : hasArmorEquipped;
    }

    /**
     * Unequips armor if the archer is alive.
     */
    public void unequipArmor() {
        hasArmorEquipped = isAlive() ? false : hasArmorEquipped;
    }

    /**
     * Trains the archer at a training ground.
     *
     * @param t the training ground
     */
    public void train(TrainingGround t) {
        if (t.isOutdoors()) {
            increaseDamage((int) (3 * t.getTrainingMultiplier()));
        }
    }

    /**
     * Checks if the archer has armor equipped.
     *
     * @return true if armor is equipped, false otherwise
     */
    public boolean hasArmor() {
        return hasArmorEquipped;
    }

    /**
     * Returns a string representation of the archer.
     *
     * @return string describing the archer's status
     */
    public String toString() {
        if (isAlive() && hasArmor()) {
            return super.toString() + " I am an archer with my armor equipped";
        }
        if (isAlive() && !hasArmor()) {
            return super.toString() + " I am an archer with my armor unequipped";
        }
        return super.toString() + " I was an archer";
    }

    /**
     * Checks if this archer is equal to another object.
     *
     * @param o the object to compare
     * @return true if equal, false otherwise
     */
    public boolean equals(Object o) {
        if (!(o instanceof Archer)) {
            return false;
        }
        Archer a = (Archer) o;
        return super.equals(a);
    }
}
