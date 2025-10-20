/**
 * The {@code Dumbbell} class represents a type of free weight equipment
 * with a specific grip type.
 *
 * <p>
 * This class extends {@link FreeWeight} and adds a {@code gripType}
 * property that describes the type of grip on the dumbbell.
 * </p>
 *
 * @author Thomas Wen
 * @version 1
 */

public class Dumbbell extends FreeWeight {
    private String gripType;

    /**
     * Constructs a new {@code Dumbbell} with the specified ID, weight, and grip type.
     *
     * <p>
     * The dumbbell's category is set to 2.
     * </p>
     *
     * @param freeWeightID the unique identifier for this dumbbell
     * @param weight the weight of the dumbbell
     * @param gripType the type of grip on this dumbbell
     */
    public Dumbbell(String freeWeightID, int weight, String gripType) {
        super(freeWeightID, 2, weight);
        this.gripType = gripType;
    }

    /**
     * Compares this dumbbell with another FreeWeight for ordering.
     *
     * @param f the {@link FreeWeight} to compare with
     * @return a negative integer, zero, or a positive integer as this
     *         dumbbell is less than, equal to, or greater than the specified object
     */
    public int compareTo(FreeWeight f) {
        int n = super.compareTo(f);
        if (n != 0) {
            return n;
        }

        Dumbbell d = (Dumbbell) f;
        if (!gripType.equals(d.gripType)) {
            return gripType.compareTo(d.gripType);
        }

        return getFreeWeightID().compareTo(d.getFreeWeightID());
    }

    /**
     * Returns a string representation of this dumbbell.
     *
     * <p>
     * The format includes the base {@link FreeWeight} string followed by
     * " dumbbell with [gripType] grip".
     * </p>
     *
     * @return a string representing this dumbbell
     */
    public String toString() {
        return super.toString() + " dumbbell with " + gripType + " grip";
    }

    /**
     * Returns the type of grip on this dumbbell.
     *
     * @return the grip type
     */
    public String getGripType() {
        return gripType;
    }
}
