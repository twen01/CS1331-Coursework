/**
 * The {@code WeightMachine} class represents a gym weight machine
 * that can be adjusted in discrete weight increments.
 *
 * <p>
 * This class implements {@link Adjustable} for modifying the machine's
 * current weight and {@link Comparable} to allow ordering machines based
 * on maximum weight, current weight, and ID.
 * </p>
 *
 * @author Thomas Wen
 * @version 1
 */

public class WeightMachine implements Adjustable, Comparable<WeightMachine> {
    private String weightMachineID;
    private int weightIncrement;
    private int maxWeight;
    private int currentWeight;

    /**
     * Constructs a new {@code WeightMachine} with the specified ID,
     * weight increment, and maximum weight.
     *
     * <p>
     * The initial current weight is set to 0.
     * </p>
     *
     * @param weightMachineID the unique identifier for this weight machine
     * @param weightIncrement the discrete weight increment
     * @param maxWeight       the maximum weight allowed on the machine
     */
    public WeightMachine(String weightMachineID, int weightIncrement, int maxWeight) {
        this.weightMachineID = weightMachineID;
        this.weightIncrement = weightIncrement;
        this.maxWeight = maxWeight;
        currentWeight = 0;
    }

    /**
     * Compares this weight machine with another for ordering.
     *
     * <p>
     * The ordering is based on:
     * <ol>
     * <li>maximum weight (ascending)</li>
     * <li>current weight (descending)</li>
     * <li>weightMachineID (lexicographical order)</li>
     * </ol>
     * </p>
     *
     * @param w the {@link WeightMachine} to compare with
     * @return a negative integer, zero, or a positive integer as this
     *         machine is less than, equal to, or greater than the specified object
     */
    public int compareTo(WeightMachine w) {
        if (maxWeight != w.maxWeight) {
            return maxWeight - w.maxWeight;
        }
        if (currentWeight != w.currentWeight) {
            return -(currentWeight - w.currentWeight);
        }
        return weightMachineID.compareTo(w.weightMachineID);
    }

    /**
     * Adjusts the current weight of the machine by the specified amount.
     *
     * <p>
     * The adjustment is only successful if:
     * <ul>
     * <li>the resulting weight is between 0 and {@code maxWeight}</li>
     * <li>the weight change is a multiple of {@code weightIncrement}</li>
     * </ul>
     * </p>
     *
     * @param weight the amount to add to (or remove from) the current weight
     * @return {@code true} if the adjustment was successful; {@code false}
     *         otherwise
     */
    public boolean adjustWeight(int weight) {
        if (currentWeight + weight < 0 || currentWeight + weight > maxWeight || weight % weightIncrement != 0) {
            return false;
        }
        currentWeight += weight;
        return true;
    }

    /**
     * Returns a string representation of this weight machine.
     *
     * <p>
     * The format is "[weightMachineID]: [currentWeight] lb. weight machine".
     * </p>
     *
     * @return a string representing this weight machine
     */
    public String toString() {
        return weightMachineID + ": " + currentWeight + " lb. weight machine";
    }

    /**
     * Returns the unique identifier for this weight machine.
     *
     * @return the weight machine ID
     */
    public String getWeightMachineID() {
        return weightMachineID;
    }

    /**
     * Returns the weight increment for this machine.
     *
     * @return the weight increment
     */
    public int getWeightIncrement() {
        return weightIncrement;
    }

    /**
     * Returns the maximum weight that can be loaded on this machine.
     *
     * @return the maximum weight
     */
    public int getMaxWeight() {
        return maxWeight;
    }

    /**
     * Returns the current weight loaded on this machine.
     *
     * @return the current weight
     */
    public int getCurrentWeight() {
        return currentWeight;
    }
}
