/**
 * Comprehensive test suite for Gym Equipment classes
 */
public class GymEquipmentTester {
    private static int testsRun = 0;
    private static int testsPassed = 0;

    public static void main(String[] args) {
        System.out.println("=== STARTING GYM EQUIPMENT AUTOGRADER ===\n");
        
        testBarbell();
        testDumbbell();
        testWeightMachine();
        testGym();
        testComparable();
        testAdjustable();
        
        System.out.println("\n=== TEST SUMMARY ===");
        System.out.println("Tests Run: " + testsRun);
        System.out.println("Tests Passed: " + testsPassed);
        System.out.println("Tests Failed: " + (testsRun - testsPassed));
        System.out.println("Pass Rate: " + (100.0 * testsPassed / testsRun) + "%");
    }

    private static void testBarbell() {
        System.out.println("--- TESTING BARBELL ---");
        
        // Test constructor and getters
        test("Barbell Constructor & Getters", () -> {
            Barbell b = new Barbell("BB-001", 45, 300);
            return b.getFreeWeightID().equals("BB-001") 
                && b.getWeight() == 45 
                && b.getLoadCapacity() == 300
                && b.getLoadedWeight() == 0;
        });
        
        // Test adjustWeight - valid adjustment
        test("Barbell adjustWeight - Valid Increase", () -> {
            Barbell b = new Barbell("BB-002", 45, 300);
            boolean result = b.adjustWeight(100);
            return result && b.getLoadedWeight() == 100;
        });
        
        // Test adjustWeight - exceeds capacity
        test("Barbell adjustWeight - Exceeds Capacity", () -> {
            Barbell b = new Barbell("BB-003", 45, 300);
            b.adjustWeight(200);
            boolean result = b.adjustWeight(150); // Would be 350 total
            return !result && b.getLoadedWeight() == 200;
        });
        
        // Test adjustWeight - negative below zero
        test("Barbell adjustWeight - Negative Below Zero", () -> {
            Barbell b = new Barbell("BB-004", 45, 300);
            b.adjustWeight(50);
            boolean result = b.adjustWeight(-100);
            return !result && b.getLoadedWeight() == 50;
        });
        
        // Test adjustWeight - valid decrease
        test("Barbell adjustWeight - Valid Decrease", () -> {
            Barbell b = new Barbell("BB-005", 45, 300);
            b.adjustWeight(100);
            boolean result = b.adjustWeight(-25);
            return result && b.getLoadedWeight() == 75;
        });
        
        // Test toString
        test("Barbell toString", () -> {
            Barbell b = new Barbell("BB-006", 45, 300);
            String expected = "BB-006: 45 lb. barbell";
            return b.toString().equals(expected);
        });
        
        System.out.println();
    }

    private static void testDumbbell() {
        System.out.println("--- TESTING DUMBBELL ---");
        
        // Test constructor and getters
        test("Dumbbell Constructor & Getters", () -> {
            Dumbbell d = new Dumbbell("DB-001", 25, "rubber");
            return d.getFreeWeightID().equals("DB-001") 
                && d.getWeight() == 25 
                && d.getGripType().equals("rubber");
        });
        
        // Test toString
        test("Dumbbell toString", () -> {
            Dumbbell d = new Dumbbell("DB-002", 50, "knurled");
            String expected = "DB-002: 50 lb. dumbbell with knurled grip";
            return d.toString().equals(expected);
        });
        
        System.out.println();
    }

    private static void testWeightMachine() {
        System.out.println("--- TESTING WEIGHT MACHINE ---");
        
        // Test constructor and getters
        test("WeightMachine Constructor & Getters", () -> {
            WeightMachine wm = new WeightMachine("WM-001", 10, 200);
            return wm.getWeightMachineID().equals("WM-001") 
                && wm.getWeightIncrement() == 10 
                && wm.getMaxWeight() == 200
                && wm.getCurrentWeight() == 0;
        });
        
        // Test adjustWeight - valid adjustment (multiple of increment)
        test("WeightMachine adjustWeight - Valid Multiple", () -> {
            WeightMachine wm = new WeightMachine("WM-002", 10, 200);
            boolean result = wm.adjustWeight(50);
            return result && wm.getCurrentWeight() == 50;
        });
        
        // Test adjustWeight - not a multiple of increment
        test("WeightMachine adjustWeight - Invalid Increment", () -> {
            WeightMachine wm = new WeightMachine("WM-003", 10, 200);
            boolean result = wm.adjustWeight(25); // Not multiple of 10
            return !result && wm.getCurrentWeight() == 0;
        });
        
        // Test adjustWeight - exceeds max
        test("WeightMachine adjustWeight - Exceeds Max", () -> {
            WeightMachine wm = new WeightMachine("WM-004", 10, 200);
            wm.adjustWeight(150);
            boolean result = wm.adjustWeight(100); // Would be 250
            return !result && wm.getCurrentWeight() == 150;
        });
        
        // Test adjustWeight - negative below zero
        test("WeightMachine adjustWeight - Negative Below Zero", () -> {
            WeightMachine wm = new WeightMachine("WM-005", 10, 200);
            wm.adjustWeight(30);
            boolean result = wm.adjustWeight(-40);
            return !result && wm.getCurrentWeight() == 30;
        });
        
        // Test adjustWeight - valid decrease
        test("WeightMachine adjustWeight - Valid Decrease", () -> {
            WeightMachine wm = new WeightMachine("WM-006", 10, 200);
            wm.adjustWeight(80);
            boolean result = wm.adjustWeight(-30);
            return result && wm.getCurrentWeight() == 50;
        });
        
        // Test toString
        test("WeightMachine toString", () -> {
            WeightMachine wm = new WeightMachine("WM-007", 10, 200);
            wm.adjustWeight(100);
            String expected = "WM-007: 100 lb. weight machine";
            return wm.toString().equals(expected);
        });
        
        System.out.println();
    }

    private static void testGym() {
        System.out.println("--- TESTING GYM ---");
        
        // Test empty constructor
        test("Gym Empty Constructor", () -> {
            Gym gym = new Gym();
            return gym.getEquipmentCount() == 0;
        });
        
        // Test 2-arg constructor
        test("Gym 2-arg Constructor", () -> {
            FreeWeight[] fws = {
                new Barbell("BB-001", 45, 300),
                new Dumbbell("DB-001", 25, "rubber")
            };
            WeightMachine[] wms = {
                new WeightMachine("WM-001", 10, 200)
            };
            Gym gym = new Gym(fws, wms);
            return gym.getEquipmentCount() == 3;
        });
        
        // Test addEquipment(FreeWeight)
        test("Gym addEquipment - FreeWeight", () -> {
            Gym gym = new Gym();
            gym.addEquipment(new Barbell("BB-001", 45, 300));
            return gym.getEquipmentCount() == 1;
        });
        
        // Test addEquipment(WeightMachine)
        test("Gym addEquipment - WeightMachine", () -> {
            Gym gym = new Gym();
            gym.addEquipment(new WeightMachine("WM-001", 10, 200));
            return gym.getEquipmentCount() == 1;
        });
        
        // Test getFreeWeight
        test("Gym getFreeWeight - Found", () -> {
            Gym gym = new Gym();
            Barbell b = new Barbell("BB-001", 45, 300);
            gym.addEquipment(b);
            FreeWeight found = gym.getFreeWeight("BB-001");
            return found != null && found.getFreeWeightID().equals("BB-001");
        });
        
        // Test getFreeWeight - Not Found
        test("Gym getFreeWeight - Not Found", () -> {
            Gym gym = new Gym();
            gym.addEquipment(new Barbell("BB-001", 45, 300));
            FreeWeight found = gym.getFreeWeight("BB-999");
            return found == null;
        });
        
        // Test getWeightMachine
        test("Gym getWeightMachine - Found", () -> {
            Gym gym = new Gym();
            WeightMachine wm = new WeightMachine("WM-001", 10, 200);
            gym.addEquipment(wm);
            WeightMachine found = gym.getWeightMachine("WM-001");
            return found != null && found.getWeightMachineID().equals("WM-001");
        });
        
        // Test getWeightMachine - Not Found
        test("Gym getWeightMachine - Not Found", () -> {
            Gym gym = new Gym();
            gym.addEquipment(new WeightMachine("WM-001", 10, 200));
            WeightMachine found = gym.getWeightMachine("WM-999");
            return found == null;
        });
        
        System.out.println();
    }

    private static void testComparable() {
        System.out.println("--- TESTING COMPARABLE ---");
        
        // Test Barbell compareTo - by category
        test("Barbell compareTo - Category Order", () -> {
            Barbell b1 = new Barbell("BB-001", 45, 300);
            Dumbbell d1 = new Dumbbell("DB-001", 25, "rubber");
            return b1.compareTo(d1) < 0; // Barbell (cat 1) < Dumbbell (cat 2)
        });
        
        // Test Barbell compareTo - by weight
        test("Barbell compareTo - Weight Order", () -> {
            Barbell b1 = new Barbell("BB-001", 35, 300);
            Barbell b2 = new Barbell("BB-002", 45, 300);
            return b1.compareTo(b2) < 0; // 35 < 45
        });
        
        // Test Barbell compareTo - by loadCapacity
        test("Barbell compareTo - Load Capacity Order", () -> {
            Barbell b1 = new Barbell("BB-001", 45, 200);
            Barbell b2 = new Barbell("BB-002", 45, 300);
            return b1.compareTo(b2) < 0; // 200 < 300
        });
        
        // Test Barbell compareTo - by loadedWeight (descending)
        test("Barbell compareTo - Loaded Weight Order", () -> {
            Barbell b1 = new Barbell("BB-001", 45, 300);
            Barbell b2 = new Barbell("BB-002", 45, 300);
            b1.adjustWeight(100);
            b2.adjustWeight(50);
            return b1.compareTo(b2) < 0; // 100 > 50, descending so b1 < b2
        });
        
        // Test Barbell compareTo - by ID
        test("Barbell compareTo - ID Order", () -> {
            Barbell b1 = new Barbell("BB-001", 45, 300);
            Barbell b2 = new Barbell("BB-002", 45, 300);
            return b1.compareTo(b2) < 0; // "BB-001" < "BB-002"
        });
        
        // Test Dumbbell compareTo - by gripType
        test("Dumbbell compareTo - Grip Type Order", () -> {
            Dumbbell d1 = new Dumbbell("DB-001", 25, "knurled");
            Dumbbell d2 = new Dumbbell("DB-002", 25, "rubber");
            return d1.compareTo(d2) < 0; // "knurled" < "rubber"
        });
        
        // Test Dumbbell compareTo - by ID
        test("Dumbbell compareTo - ID Order", () -> {
            Dumbbell d1 = new Dumbbell("DB-001", 25, "rubber");
            Dumbbell d2 = new Dumbbell("DB-002", 25, "rubber");
            return d1.compareTo(d2) < 0; // "DB-001" < "DB-002"
        });
        
        // Test WeightMachine compareTo - by maxWeight
        test("WeightMachine compareTo - Max Weight Order", () -> {
            WeightMachine wm1 = new WeightMachine("WM-001", 10, 150);
            WeightMachine wm2 = new WeightMachine("WM-002", 10, 200);
            return wm1.compareTo(wm2) < 0; // 150 < 200
        });
        
        // Test WeightMachine compareTo - by currentWeight (descending)
        test("WeightMachine compareTo - Current Weight Order", () -> {
            WeightMachine wm1 = new WeightMachine("WM-001", 10, 200);
            WeightMachine wm2 = new WeightMachine("WM-002", 10, 200);
            wm1.adjustWeight(100);
            wm2.adjustWeight(50);
            return wm1.compareTo(wm2) < 0; // 100 > 50, descending so wm1 < wm2
        });
        
        // Test WeightMachine compareTo - by ID
        test("WeightMachine compareTo - ID Order", () -> {
            WeightMachine wm1 = new WeightMachine("WM-001", 10, 200);
            WeightMachine wm2 = new WeightMachine("WM-002", 10, 200);
            return wm1.compareTo(wm2) < 0; // "WM-001" < "WM-002"
        });
        
        System.out.println();
    }

    private static void testAdjustable() {
        System.out.println("--- TESTING ADJUSTABLE INTERFACE ---");
        
        // Test that Barbell implements Adjustable
        test("Barbell implements Adjustable", () -> {
            Barbell b = new Barbell("BB-001", 45, 300);
            return b instanceof Adjustable;
        });
        
        // Test that WeightMachine implements Adjustable
        test("WeightMachine implements Adjustable", () -> {
            WeightMachine wm = new WeightMachine("WM-001", 10, 200);
            return wm instanceof Adjustable;
        });
        
        // Test polymorphism with Adjustable
        test("Adjustable Polymorphism", () -> {
            Adjustable adj1 = new Barbell("BB-001", 45, 300);
            Adjustable adj2 = new WeightMachine("WM-001", 10, 200);
            boolean result1 = adj1.adjustWeight(50);
            boolean result2 = adj2.adjustWeight(50);
            return result1 && result2;
        });
        
        System.out.println();
    }

    // Helper method to run tests
    private static void test(String testName, TestCase testCase) {
        testsRun++;
        try {
            boolean result = testCase.run();
            if (result) {
                testsPassed++;
                System.out.println("✓ PASS: " + testName);
            } else {
                System.out.println("✗ FAIL: " + testName);
            }
        } catch (Exception e) {
            System.out.println("✗ ERROR: " + testName + " - " + e.getMessage());
        }
    }

    @FunctionalInterface
    interface TestCase {
        boolean run();
    }
}