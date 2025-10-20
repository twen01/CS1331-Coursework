/**
 * Concrete class extending Entity.
 *
 * @author CS 1331 TAs
 * @version 1.0
 */

public class EntityConcrete extends Entity {

    /**
     * Constructs an EntityConcrete (which is, effectively, an Entity) with the given name and health.
     *
     * @param name   the name of the entity
     * @param health the health of the entity
     */
    public EntityConcrete(String name, int health) {
        super(name, health);
    }
}
