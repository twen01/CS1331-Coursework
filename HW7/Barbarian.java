/**
 * Represents barbarians in the army
 * 
 * @author Thomas Wen
 * @version 1
 */
public class Barbarian extends Troop implements Treatable {
    private final boolean isElite;

    /**
     * 4-arg constructor
     * 
     * @param name
     * @param experienceLevel
     * @param health
     * @param isElite
     */
    public Barbarian(String name, int experienceLevel, int health, boolean isElite) {
        super(name, experienceLevel, health);
        this.isElite = isElite;
    }

    /**
     * 1-arg constructor
     * 
     * @param isElite
     */
    public Barbarian(boolean isElite) {
        super("Buzz", 1, 25);
        this.isElite = isElite;
    }

    /**
     * Returns is elite or not
     * 
     * @return
     */
    public boolean isElite() {
        return isElite;
    }

    /**
     * Method with a lot of stuff
     * 
     * @param t
     */
    public void trainWith(Troop t) {
        if (!(getHealth() < 10 || getHealth() == 100) && !(t instanceof Barbarian || t instanceof Archer)
                && getExperienceLevel() != 50) {
            if (t instanceof Barbarian) {
                int health = getHealth();
                setHealth(getHealth() - (int) (t.getExperienceLevel() * 0.1));
                t.setHealth(t.getHealth() - (int) (t.getExperienceLevel() * 0.1));
                System.out.println("AAAARGH! I just trained with a level " + t.getExperienceLevel()
                        + " barbarian, and my health went from " + health + " to " + getHealth());
                if (isElite() == false && ((Barbarian) t).isElite() == false) {
                    setExperienceLevel(getExperienceLevel() + 5);
                    t.setExperienceLevel(t.getExperienceLevel() + 5);
                } else {
                    setExperienceLevel(getExperienceLevel() + 8);
                    t.setExperienceLevel(t.getExperienceLevel() + 8);

                }
            }
            if (t instanceof Archer) {
                // complete after finishing Archer class
            }
        }
    }

    /**
     * increase health by 5
     */
    public void treat() {
        setHealth(getHealth() + 5);
    }

    /**
     * health maximum?
     * 
     * @return
     */
    public boolean needsTreatment() {
        return getHealth() != 100;
    }

    /**
     * WHY ARE YOU MAKING ME DO THIS AAAARGH!
     */
    public void scream() {
        System.out.println("AAAARGH!");
    }

    /**
     * toString
     * 
     * @return String
     */
    public String toString() {
        if (isElite()) {
            return super.toString() + ". I am an elite barbarian";
        }
        return super.toString() + ". I am a regular barbarian";
    }

    /**
     * equals method yay
     * 
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Barbarian)) {
            return false;
        }
        Barbarian b = (Barbarian) o;
        return super.equals(b) && isElite() == b.isElite();
    }
}