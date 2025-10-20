/**
 * The {@code FreeWeight} abstract class represents generic free weight gym
 * equipment.
 *
 * <p>
 * It serves as a base class for specific types of free weights such as
 * {@link Barbell} and {@link Dumbbell}. Free weights have an ID, category,
 * and weight, and they can be compared with each other based on category and
 * weight.
 * </p>
 *
 * @author Thomas Wen
 * @version 1
 * @see Comparable
 */

public abstract class FreeWeight implements Comparable<FreeWeight> {
    private String freeWeightID;
    private int category;
    private int weight;

    /**
     * Constructs a new {@code FreeWeight} with the specified ID, category, and
     * weight.
     *
     * @param freeWeightID the unique identifier for this free weight
     * @param category     the category of the free weight (used for ordering)
     * @param weight       the weight of the free weight
     */
    public FreeWeight(String freeWeightID, int category, int weight) {
        this.freeWeightID = freeWeightID;
        this.category = category;
        this.weight = weight;
    }

    /**
     * Compares this free weight with another for ordering.
     *
     * @param f the {@link FreeWeight} to compare with
     * @return a negative integer, zero, or a positive integer as this
     *         free weight is less than, equal to, or greater than the specified
     *         object
     */
    public int compareTo(FreeWeight f) {
        if (category != f.category) {
            return category - f.category;
        }
        if (weight != f.weight) {
            return weight - f.weight;
        }
        return 0;
    }

    /**
     * Returns a string representation of this free weight.
     *
     * <p>
     * The format is "[freeWeightID]: [weight] lb.".
     * </p>
     *
     * @return a string representing this free weight
     */
    public String toString() {
        return freeWeightID + ": " + weight + " lb.";
    }

    /**
     * Returns the unique identifier for this free weight.
     *
     * @return the free weight ID
     */
    public String getFreeWeightID() {
        return freeWeightID;
    }

    /**
     * Returns the weight of this free weight.
     *
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }
}
