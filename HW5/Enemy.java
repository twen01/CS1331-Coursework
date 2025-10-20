/**
 * Represents an enemy with optional armor-piercing ability.
 *
 * @author Thomas Wen
 * @version 1.0
 */
public class Enemy extends Entity {
    private boolean canPierceArmor;

    /**
     * Constructs an enemy with given attributes.
     *
     * @param name           the enemy's name
     * @param health         the enemy's health
     * @param canPierceArmor whether the enemy can pierce armor
     */
    public Enemy(String name, int health, boolean canPierceArmor) {
        super(name, health);
        this.canPierceArmor = canPierceArmor;
    }

    /**
     * Constructs an enemy that cannot pierce armor.
     *
     * @param name   the enemy's name
     * @param health the enemy's health
     */
    public Enemy(String name, int health) {
        this(name, health, false);
    }

    /**
     * Checks if the enemy can pierce armor.
     *
     * @return true if can pierce armor, false otherwise
     */
    public boolean canPierceArmor() {
        return canPierceArmor;
    }

    /**
     * Attacks a hero, dealing damage based on armor.
     *
     * @param h the hero to attack
     */
    public void attack(Hero h) {
        if (isAlive() && h.isAlive()) {
            if (!h.hasArmor() || canPierceArmor) {
                h.takeDamage(3);
            } else {
                h.takeDamage(1);
            }
        }
    }

    /**
     * Returns a string representation of the enemy.
     *
     * @return string describing the enemy's status
     */
    public String toString() {
        if (isAlive() && canPierceArmor()) {
            return super.toString() + ". I am an enemy that can pierce armor";
        }
        if (isAlive() && !canPierceArmor()) {
            return super.toString() + ". I am an enemy that cannot pierce armor";
        }
        return super.toString() + ". I was an enemy";
    }

    /**
     * Checks if this enemy is equal to another object.
     *
     * @param o the object to compare
     * @return true if equal, false otherwise
     */
    public boolean equals(Object o) {
        if (!(o instanceof Enemy)) {
            return false;
        }
        Enemy e = (Enemy) o;
        return super.equals(e) && canPierceArmor() == e.canPierceArmor();
    }
}
