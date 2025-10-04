public class Animal {
    private String species;
    private String name;
    private int energy;
    private int health;
    private static int numberOfAnimals;

    public Animal(String species, String name, int energy, int health) {
        this.species = species;
        this.name = name;
        this.energy = (energy > 100) ? 100 : ((energy < 1) ? 1 : energy);
        this.health = (health > 100) ? 100 : ((health < 1) ? 1 : health);
        numberOfAnimals++;
    }

    public Animal(String species, String name) {
        this.species = species;
        this.name = name;
        energy = 50;
        health = 100;
        numberOfAnimals++;
    }

    public Animal(String name) {
        species = "Unknown";
        this.name = name;
        energy = 50;
        health = 100;
        numberOfAnimals++;
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public int getHealth() {
        return health;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public void setEnergy(int energy) {
        if (energy >= 1 && energy <= 100) {
            this.energy = energy;
        }
    }

    public void setHealth(int health) {
        if (health >= 1 && health <= 100) {
            this.health = health;
        }
    }

    public static int getNumberOfAnimals() {
        return numberOfAnimals;
    }

    public void eat(int n) {
        energy += 2 * n;
        if (energy > 100) {
            energy = 100;
        }
    }

    public void doActivity(int duration, boolean dangerous) {
        energy -= duration * 5;
        if (dangerous) {
            health -= 3 * duration;
        }
        if (energy < 1) {
            energy = 1;
        }
        if (health < 1) {
            health = 1;
        }
    }

    public void goToZooHospital() {
        health = 100;
        energy = (energy < 60) ? 60 : energy;
    }

    public boolean isHungry() {
        return energy < 50;
    }

    public String toString() {
        return "I am " + species + " " + name + ". I have " + energy + " energy and " + health + " health";
    }
}
