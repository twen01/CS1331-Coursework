//I worked on the homework assignment alone, using only course materials.

import java.util.Scanner;

public class Zoo {
    public static void main(String[] args) {
        int numHabitats = Integer.parseInt(args[0]);
        int numAnimals = Integer.parseInt(args[1]);

        Habitat[] habitats = new Habitat[numHabitats];
        Animal[] animals = new Animal[numAnimals];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numHabitats; i++) {
            String name = scanner.next();
            int capacity = scanner.nextInt();
            scanner.nextLine();
            habitats[i] = new Habitat(name, capacity);
        }

        int habitatsIndex = 0;
        for (int i = 0; i < numAnimals; i++) {
            if (habitatsIndex >= numHabitats) {
                habitatsIndex = 0;
            }
            while (habitatsIndex < numHabitats) {
                if (habitats[habitatsIndex].isFull()) {
                    habitatsIndex++;
                    continue;
                }
                String species = scanner.next();
                String name = scanner.next();
                int energy = scanner.nextInt();
                int health = scanner.nextInt();
                scanner.nextLine();
                animals[i] = new Animal(species, name, energy, health);
                habitats[habitatsIndex].addAnimal(animals[i]);
                habitatsIndex++;
                break;
            }
        }

        System.out.println();
        System.out.println("Habitats and their animals at the beginning of the day:");
        for (int i = 0; i < numHabitats; i++) {
            System.out.println(habitats[i].toString());
            Animal[] animalsInHabitat = habitats[i].getAllAnimals();
            for (int k = 0; k < animalsInHabitat.length; k++) {
                System.out.println(animalsInHabitat[k].toString());
            }
        }

        if (numHabitats >= 2 && habitats[0].getHungryAnimals().length >= 1
                && habitats[habitats.length - 1].getHungryAnimals().length != habitats[habitats.length - 1]
                        .getAnimalCount()) {
            Animal animal = habitats[0].getHungryAnimals()[0];
            habitats[0].removeAnimal(animal);
            habitats[habitats.length - 1].addAnimal(animal);
        }

        habitats[habitats.length - 1].feedAnimals(10);

        System.out.println();
        System.out.println("Habitats and their animals at the end of the day:");
        for (int i = 0; i < numHabitats; i++) {
            System.out.println(habitats[i].toString());
            Animal[] animalsInHabitat = habitats[i].getAllAnimals();
            for (int k = 0; k < animalsInHabitat.length; k++) {
                System.out.println(animalsInHabitat[k].toString());
            }
        }
    }
}
