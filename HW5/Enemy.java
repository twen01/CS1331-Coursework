public class Enemy extends Entity {
    private boolean canPierceArmor;

    public Enemy(String name, int health, boolean canPierceArmor) {
        super(name, health);
        this.canPierceArmor = canPierceArmor;
    }

    public Enemy(String name, int health) {
        super(name, health);
        canPierceArmor = false;
    }

    public boolean canPierceArmor() {
        return canPierceArmor;
    }

    public void attack(Hero h) {
        if (h.isAlive()) {
            if (!h.hasArmor() || canPierceArmor) {
                h.takeDamage(3);
            } else {
                h.takeDamage(1);
            }
        }
    }

    public String toString() {
        if (isAlive() && canPierceArmor()) {
            return super.toString() + ". I am an enemy that can pierce armor";
        }
        if (isAlive() && !canPierceArmor()) {
            return super.toString() + ". I am an enemy that cannot pierce armor";
        }
        return super.toString() + ". I was an enemy";
    }

    public boolean equals(Enemy e) {
        return super.equals(e) && canPierceArmor() == e.canPierceArmor();
    }
}
