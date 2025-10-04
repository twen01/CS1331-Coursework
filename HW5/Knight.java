public class Knight extends Hero {
    public Knight(String name, int health, int damage) {
        super(name, health, damage);
    }

    public Knight(String name, int health) {
        super(name, health, 2);
    }

    public Knight(String name) {
        super(name, 40, 2);
    }

    public void train(TrainingGround t) {
        increaseDamage((int) (5 * t.getTrainingMultiplier()));
    }

    public boolean hasArmor() {
        return true;
    }

    public String toString() {
        return isAlive() ? super.toString() + " I am a knight." : super.toString() + " I was a knight.";
    }

    public boolean equals(Knight k) {
        return super.equals(k);
    }
}