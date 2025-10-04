public class Habitat {
    private String name;
    private Animal[] animals;
    private int animalCount;

    public Habitat(String name, int capacity) {
        this.name = name;
        animals = new Animal[capacity];
    }

    public boolean isFull() {
        for (Animal a : animals) {
            if (a == null) {
                return false;
            }
        }
        return true;
    }

    public int getCapacity() {
        return animals.length;
    }

    public boolean addAnimal(Animal a) {
        if (isFull() || a == null) {
            return false;
        }
        for (Animal b : animals) {
            if (b != null && b.equals(a)) {
                return false;
            }
        }
        int minIndex = 0;
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                minIndex = i;
                break;
            }
        }
        animals[minIndex] = a;
        animalCount++;

        return true;
    }

    public boolean removeAnimal(Animal animal) {
        int index = -1;
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null && animals[i].equals(animal)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }

        for (int i = index + 1; i < animals.length; i++) {
            animals[i - 1] = animals[i];
        }
        animals[animals.length - 1] = null;
        animalCount--;

        return true;
    }

    public void feedAnimals(int n) {
        for (Animal a : animals) {
            if (a != null) {
                a.eat(n);
            }
        }
    }

    public Animal[] getAllAnimals() {
        int notNullCounter = 0;
        for (Animal a : animals) {
            if (a != null) {
                notNullCounter++;
            }
        }

        if (notNullCounter == 0) {
            return new Animal[] {};
        }

        Animal[] returnAnimals = new Animal[notNullCounter];
        int index = 0;
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null) {
                returnAnimals[index] = animals[i];
                index++;
            }
        }
        return returnAnimals;
    }

    public Animal[] getHungryAnimals() {
        int hungryCounter = 0;
        for (Animal a : animals) {
            if (a != null && a.isHungry()) {
                hungryCounter++;
            }
        }

        if (hungryCounter == 0) {
            return new Animal[] {};
        }

        Animal[] hungryAnimals = new Animal[hungryCounter];
        int index = 0;
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null && animals[i].isHungry()) {
                hungryAnimals[index] = animals[i];
                index++;
            }
        }
        return hungryAnimals;
    }

    public String toString() {
        return name + " has " + animalCount + ((animalCount == 1) ? " animal" : " animals") + " and has a capacity of "
                + animals.length;
    }

    public String getName() {
        return name;
    }

    public int getAnimalCount() {
        return animalCount;
    }

    public void setName(String name) {
        this.name = name;
    }

}
