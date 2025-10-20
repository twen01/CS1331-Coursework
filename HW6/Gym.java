import java.util.Arrays;

/**
 * The {@code Gym} class represents a gym that contains collections of
 * {@link FreeWeight} and {@link WeightMachine} equipment.
 *
 * <p>
 * The class provides functionality to browse, add, and retrieve equipment,
 * while maintaining sorted arrays of free weights and weight machines.
 * </p>
 *
 * @author Thomas Wen
 * @version 1
 */
public class Gym {
    private FreeWeight[] freeWeights;
    private WeightMachine[] weightMachines;

    /**
     * Constructs a new {@code Gym} with the specified arrays of free weights
     * and weight machines. The arrays are sorted in their natural order.
     *
     * @param freeWeights    the array of free weight equipment
     * @param weightMachines the array of weight machine equipment
     */
    public Gym(FreeWeight[] freeWeights, WeightMachine[] weightMachines) {
        this.freeWeights = freeWeights;
        this.weightMachines = weightMachines;
        Arrays.sort(this.freeWeights);
        Arrays.sort(this.weightMachines);
    }

    /**
     * Constructs an empty {@code Gym} with no equipment.
     *
     * <p>
     * The freeWeights and weightMachines arrays are initialized with length 0.
     * </p>
     */
    public Gym() {
        freeWeights = new FreeWeight[0];
        weightMachines = new WeightMachine[0];
    }

    /**
     * Prints all the equipment in the gym to the console.
     *
     * <p>
     * Free weights are printed first, followed by weight machines.
     * Each piece of equipment is printed on its own line using its
     * {@link Object#toString()} representation.
     * </p>
     */
    public void browseGymEquipment() {
        for (FreeWeight f : freeWeights) {
            System.out.println(f.toString());
        }
        for (WeightMachine w : weightMachines) {
            System.out.println(w.toString());
        }
    }

    /**
     * A new array is created with the additional equipment, and the array
     * is sorted in natural order.
     *
     * @param f the {@link FreeWeight} to add
     */
    public void addEquipment(FreeWeight f) {
        FreeWeight[] a = new FreeWeight[freeWeights.length + 1];
        for (int i = 0; i < freeWeights.length; i++) {
            a[i] = freeWeights[i];
        }
        a[a.length - 1] = f;
        Arrays.sort(a);
        freeWeights = a;
    }

    /**
     * A new array is created with the additional equipment, and the array
     * is sorted in natural order.
     *
     * @param f the {@link WeightMachine} to add
     */
    public void addEquipment(WeightMachine f) {
        WeightMachine[] a = new WeightMachine[weightMachines.length + 1];
        for (int i = 0; i < weightMachines.length; i++) {
            a[i] = weightMachines[i];
        }
        a[a.length - 1] = f;
        Arrays.sort(a);
        weightMachines = a;
    }

    /**
     * Retrieves a {@link FreeWeight} from the gym based on its ID.
     *
     * @param str the ID of the free weight to search for
     * @return the {@link FreeWeight} with the matching ID, or {@code null} if not
     *         found
     */
    public FreeWeight getFreeWeight(String str) {
        for (FreeWeight f : freeWeights) {
            if (str.equals(f.getFreeWeightID())) {
                return f;
            }
        }
        return null;
    }

    /**
     * Retrieves a {@link WeightMachine} from the gym based on its ID.
     *
     * @param str the ID of the weight machine to search for
     * @return the {@link WeightMachine} with the matching ID, or {@code null} if
     *         not found
     */
    public WeightMachine getWeightMachine(String str) {
        for (WeightMachine w : weightMachines) {
            if (str.equals(w.getWeightMachineID())) {
                return w;
            }
        }
        return null;
    }

    /**
     * Returns the total number of equipment in the gym, including both
     * free weights and weight machines.
     *
     * @return the total count of equipment
     */
    public int getEquipmentCount() {
        return freeWeights.length + weightMachines.length;
    }
}
