public class Archer extends Hero {
    private boolean hasArmorEquipped;

    public Archer(String name, int health, int damage, boolean hasArmorEquipped) {
        super(name, health, damage);
        this.hasArmorEquipped = hasArmorEquipped;
    }

    public Archer(String name, int health) {
        super(name, health, 4);
        hasArmorEquipped = false;
    }

    public Archer(String name) {
        super(name, 20, 4);
        hasArmorEquipped = false;
    }

    public void equipArmor() {
        hasArmorEquipped = isAlive() ? true : hasArmorEquipped;
    }

    public void unequipArmor() {
        hasArmorEquipped = isAlive() ? false : hasArmorEquipped;
    }

    public void train(TrainingGround t) {
        if (t.isOutdoors()) {
            increaseDamage((int) (3 * t.getTrainingMultiplier()));
        }
    }

    public boolean hasArmor() {
        return hasArmorEquipped;
    }

    public String toString() {
        if (isAlive() && hasArmor()) {
            return super.toString() + " I am an archer with my armor equipped";
        }
        if (isAlive() && !hasArmor()) {
            return super.toString() + " I am an archer with my armor unequipped";
        }
        return super.toString() + " I was an archer";
    }

    public boolean equals(Archer a) {
        return super.equals(a);
    }
}