/**
 * The {@code Barbell} class represents a type of free weight equipment
 * that is adjustable and can be loaded with additional weight plates.
 *
 * <p>
 * This class extends {@link FreeWeight} and implements {@link Adjustable}.
 * Barbells have a maximum load capacity, a current loaded weight,
 * and are categorized under free weight equipment.
 * </p>
 *
 * @author Thomas Wen
 * @version 1
 */
public class Barbell extends FreeWeight implements Adjustable {
    private int loadCapacity;
    private int loadedWeight;

    /**
     * Constructs a new {@code Barbell} with the specified ID, weight, and load capacity.
     *
     * @param freeWeightID the unique identifier for this barbell
     * @param weight       the base weight of the barbell (without plates)
     * @param loadCapacity the maximum weight the barbell can hold
     */
    public Barbell(String freeWeightID, int weight, int loadCapacity) {
        super(freeWeightID, 1, weight);
        this.loadCapacity = loadCapacity;
        loadedWeight = 0;
    }

    /**
     * Compares this barbell with another FreeWeight for ordering.
     *
     * @param f the {@link FreeWeight} to compare with
     * @return a negative integer, zero, or a positive integer as this
     *         barbell is less than, equal to, or greater than the specified object
     */
    public int compareTo(FreeWeight f) {
        int n = super.compareTo(f);
        if (n != 0) {
            return n;
        }

        Barbell b = (Barbell) f;
        if (loadCapacity != b.loadCapacity) {
            return loadCapacity - b.loadCapacity;
        }
        if (loadedWeight != b.loadedWeight) {
            return -(loadedWeight - b.loadedWeight);
        }

        return getFreeWeightID().compareTo(b.getFreeWeightID());
    }

    /**
     * Adjusts the loaded weight by the specified amount.
     *
     * @param weight the amount to add to (or remove from) the current loaded weight
     * @return {@code true} if the adjustment was successful; {@code false}
     *         otherwise
     */
    public boolean adjustWeight(int weight) {
        if (loadedWeight + weight < 0 || loadedWeight + weight > loadCapacity) {
            return false;
        }
        loadedWeight += weight;
        return true;
    }

    /**
     * Returns a string representation of this barbell.
     *
     * <p>
     * The format includes the base {@link FreeWeight} string followed by "
     * barbell".
     * </p>
     *
     * @return a string representing this barbell
     */
    public String toString() {
        return super.toString() + " barbell";
    }

    /**
     * Returns the maximum weight that can be loaded onto this barbell.
     *
     * @return the load capacity
     */
    public int getLoadCapacity() {
        return loadCapacity;
    }

    /**
     * Returns the current loaded weight on this barbell.
     *
     * @return the loaded weight
     */
    public int getLoadedWeight() {
        return loadedWeight;
    }
}
