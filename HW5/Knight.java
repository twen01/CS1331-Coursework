/**
 * Represents a knight hero with armor.
 *
 * @author Thomas Wen
 * @version 1.0
 */
public class Knight extends Hero {
    /**
     * Constructs a knight with given attributes.
     *
     * @param name the knight's name
     * @param health the knight's health
     * @param damage the damage the knight deals
     */
    public Knight(String name, int health, int damage) {
        super(name, health, damage);
    }

    /**
     * Constructs a knight with default damage of 2.
     *
     * @param name the knight's name
     * @param health the knight's health
     */
    public Knight(String name, int health) {
        this(name, health, 2);
    }

    /**
     * Constructs a knight with default health and damage.
     *
     * @param name the knight's name
     */
    public Knight(String name) {
        this(name, 40, 2);
    }

    /**
     * Trains the knight at a training ground.
     *
     * @param t the training ground
     */
    public void train(TrainingGround t) {
        increaseDamage((int) (5 * t.getTrainingMultiplier()));
    }

    /**
     * Checks if the knight has armor.
     *
     * @return always true for knights
     */
    public boolean hasArmor() {
        return true;
    }

    /**
     * Returns a string representation of the knight.
     *
     * @return string describing the knight's status
     */
    public String toString() {
        return isAlive() ? super.toString() + " I am a knight." : super.toString() + " I was a knight.";
    }

    /**
     * Checks if this knight is equal to another object.
     *
     * @param o the object to compare
     * @return true if equal, false otherwise
     */
    public boolean equals(Object o) {
        if (!(o instanceof Knight)) {
            return false;
        }
        Knight k = (Knight) o;
        return super.equals(k);
    }
}
