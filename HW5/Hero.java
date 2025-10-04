public abstract class Hero extends Entity {
    private int damage;

    public Hero(String name, int health, int damage) {
        super(name, health);
        this.damage = damage < 0 ? 0 : damage;
    }

    public Hero(String name, int health) {
        super(name, health);
        damage = 1;
    }

    public int getDamage() {
        return damage;
    }

    protected void increaseDamage(int n) {
        damage = isAlive() ? damage + n : damage;
    }

    public void train(TrainingGround t) {

    }

    public boolean hasArmor() {
        return false;
    }

    public void attack(Enemy e) {
        if(isAlive()) {
            e.takeDamage(damage);
        }
    }

    public String toString() {
        return isAlive() ? (super.toString() + " I deal " + damage + " damage.") : super.toString();
    }

    public boolean equals(Hero h) {
        return super.equals(h) && damage == h.getDamage();
    }
}
