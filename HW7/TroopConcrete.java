/**
 * Concrete class extending Troop, used for autograding purposes only. DO NOT MODIFY THIS CLASS.
 *
 * @author CS 1331 TAs
 * @version 1
 */
public class TroopConcrete extends Troop {

    /**
     * Constructs a TroopConcrete (which is, effectively, a Troop) with the given name, experienceLevel, and health.
     *
     * @param name            the name of the troop
     * @param experienceLevel the experience level of the troop
     * @param health          the health of the troop
     */
    public TroopConcrete(String name, int experienceLevel, int health) {
        super(name, experienceLevel, health);
    }

    /**
     * The troop will train with another. In this class, its sole purpose is to allow trainWith to be a concrete method,
     * so the implementaton is empty.
     *
     * @param other the other troop
     */
    public void trainWith(Troop other) {
    }
}
