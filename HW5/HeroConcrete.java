/**
 * Concrete class extending Hero, used for autograding purposes only.
 * DO NOT MODIFY THIS CLASS.
 *
 * @author CS 1331 TAs
 * @version 1
 */
public class HeroConcrete extends Hero {

    /**
     * Constructs a HeroConcrete (which is, effectively, a Hero) with the given
     * name, health, and damage.
     *
     * @param name   the name of the hero
     * @param health the health of the hero
     * @param damage the damage the hero deals
     */
    public HeroConcrete(String name, int health, int damage) {
        super(name, health, damage);
    }

    /**
     * Constructs a HeroConcrete (which is, effectively, a Hero) with the given name
     * and health.
     *
     * @param name   the name of the hero
     * @param health the health of the hero
     */
    public HeroConcrete(String name, int health) {
        super(name, health);
    }

    /**
     * The hero will train to increase the damage it can deal.
     * In this class, its sole purpose is to allow train to be a concrete method, so
     * the implementaton is empty.
     *
     * @param trainingGround the training ground in which the hero will train
     */
    public void train(TrainingGround trainingGround) {
    }

    /**
     * The hero will check if it has armor equipped.
     * In this class, its sole purpose is to allow hasArmor to be a concrete method,
     * so the implementaton is empty.
     *
     * @return false, as it must return some boolean value
     */
    public boolean hasArmor() {
        return false;
    }
}
