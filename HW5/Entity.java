public class Entity {
    private String name;
    private int health;

    public Entity(String name, int health) {
        this.name = name;
        this.health = health;

        if (health < 0) {
            this.health = 0;
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setHealth(int health) {
        health = (health < 0) ? 0 : health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        setHealth(health - damage);
    }

    public void heal(int numHeal) {
        if (numHeal > 0 && isAlive()) {
            setHealth(health + numHeal);
        }
    }

    public String toString() {
        return (isAlive()) ? ("I am " + name + ", and I have " + health + " health") : ("I was " + name);
    }

    public boolean equals(Entity e) {
        return (name.equals(e.getName()) && health == e.getHealth());
    }
}
