
//I worked on the homework assignment alone, using only course materials.
import java.util.Scanner;

/* Represents a hotel management system */
public class Hotel {
    /* main method that executes all commands */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int floors = Integer.parseInt(args[0]);
        int rooms = Integer.parseInt(args[1]);

        /* User inputs room costs */
        if (Integer.parseInt(args[0]) < 1 || Integer.parseInt(args[1]) < 1) {
            System.out.println("Invalid number of floors or rooms.");
            System.exit(0);
        }

        int[][] hotel = new int[floors][rooms];
        String[][] availability = new String[floors][rooms];
        int[][] duration = new int[floors][rooms];

        for (String[] str : availability) {
            int j = 0;
            do {
                str[j] = " ";
                j++;
            } while (j < rooms);
        }

        int a = 0;
        while (a < floors) {
            System.out.print("Costs for floor " + (a + 1) + ": ");
            int[] temp = new int[rooms];
            boolean validFloor = true;

            for (int j = 0; j < rooms; j++) {
                temp[j] = scanner.nextInt();
                if (temp[j] <= 0) {
                    validFloor = false;
                }
            }

            if (!validFloor) {
                System.out.println("Room costs must be positive.");
                continue;
            }

            for (int j = 0; j < rooms; j++) {
                hotel[a][j] = temp[j];
            }
            a++;
        }

        boolean quit = false;

        while (!quit) {
            System.out.println();
            System.out.print("> ");
            String command = scanner.next();
            switch (command) {
                case "in":
                    String nameIn = scanner.next();
                    int durationIn = scanner.nextInt();
                    int floorIn = scanner.nextInt();
                    int roomIn = scanner.nextInt();

                    if (in(nameIn, durationIn, floorIn, roomIn, availability, duration)) {
                        // CAREFUL THAT USER INPUTTED FLOOR/ROOM IS +1 ACTUAL FLOOR/ROOM INDEX
                        availability[floorIn - 1][roomIn - 1] = nameIn;
                        duration[floorIn - 1][roomIn - 1] = durationIn;
                    }

                    break;

                case "nd":
                    int totalPayment = calculatePayment(availability, hotel);
                    int numberOfGuests = 0;
                    // counts # of guests
                    for (int i = 0; i < availability.length; i++) {
                        for (int j = 0; j < availability[i].length; j++) {
                            if (!availability[i][j].equals(" ")) {
                                numberOfGuests++;
                            }
                        }
                    }

                    System.out.print("Total payment from " + numberOfGuests
                            + ((numberOfGuests == 1) ? " guest: $" : " guests: $") + totalPayment + ".00.");

                    // check out ppl on last day and minus one day
                    for (int i = 0; i < availability.length; i++) {
                        for (int j = 0; j < availability[i].length; j++) {
                            if (duration[i][j] == 1) {
                                System.out.println();
                                System.out.print("Checking out " + availability[i][j] + " from floor " + (i + 1)
                                        + ", room " + (j + 1) + ".");
                                availability[i][j] = " ";
                            }
                            if (duration[i][j] >= 1) {
                                duration[i][j]--;
                            }
                        }
                    }

                    break;

                case "price":
                    int floorNum = scanner.nextInt();
                    int roomNum = scanner.nextInt();

                    if (floorNum > floors || roomNum > rooms || floorNum <= 0 || roomNum <= 0) {
                        System.out.print("Invalid floor or room.");
                    } else {
                        System.out.print("The price for floor " + floorNum + ", room " + roomNum + " is $"
                                + hotel[floorNum - 1][roomNum - 1] + ".00 per day.");
                    }

                    break;

                case "print":
                    for (int i = floors - 1; i >= 0; i--) {
                        for (int j = 0; j < hotel[0].length; j++) {
                            if (availability[i][j].equals(" ")) {
                                System.out.print("| ");
                            } else {
                                System.out.print("|" + availability[i][j]);
                            }
                            if (j == hotel[0].length - 1 && i > 0) {
                                System.out.println("|");
                            }
                            if (j == hotel[0].length - 1 && i == 0) {
                                System.out.print("|");
                            }
                        }
                    }
                    break;

                case "quit":
                    quit = true;
                    break;
                default: // System.out.println();
                    break;
            }
        }
    }

    /*
     * @param name guest name
     *
     * @param lengthOfStay length of stay in nights
     *
     * @param floor floor number
     *
     * @param room room number
     *
     * @param availability matrix of all guests staying in hotel
     *
     * @return returns false if someone already checked in, inputted invalid
     * floor/room number, invalid number of nights, or tries to check into an
     * occupied room
     */
    public static boolean in(String name, int lengthOfStay, int floor, int room, String[][] availability,
            int[][] duration) {
        // check if guest already checked in
        for (int i = 0; i < availability.length; i++) {
            for (int j = 0; j < availability[i].length; j++) {
                if (name.equals(availability[i][j])) {
                    System.out.print(name + " already checked in.");
                    return false;
                }
            }
        }

        // check floor/room # is invalid
        if (floor < 1 || room < 1 || floor > availability.length || room > availability[0].length) {
            System.out.print("Invalid floor or room.");
            return false;
        }

        // check lengthofstay
        if (lengthOfStay < 1) {
            System.out.println("Guests must stay at least one day.");
            return false;
        }

        // check if room is occupied
        if (!(availability[floor - 1][room - 1].equals(" "))) {
            System.out.println("Room is already occupied.");
            return false;
        }

        System.out.print("Checking in " + name + " to floor " + floor + ", room " + room + ", for " + lengthOfStay
                + ((lengthOfStay > 1) ? " days." : " day."));
        return true;
    }

    /*
     * @param availability matrix of all guests staying in hotel
     *
     * @param hotel matrix of cost of each room
     *
     * @return returns the total room charges collected in a given night
     */

    public static int calculatePayment(String[][] availability, int[][] hotel) {
        int sum = 0;
        for (int i = 0; i < availability.length; i++) {
            for (int j = 0; j < availability[0].length; j++) {
                if (availability[i][j] != null && !availability[i][j].equals(" ")) {
                    sum += hotel[i][j];
                }
            }
        }
        return sum;
    }
}
