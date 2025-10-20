//I worked on the homework assignment alone, using only course materials.

/**
 * The {@code Adjustable} interface represents gym equipment
 * whose weight can be modified dynamically.
 * Implementing classes must define how the equipment's weight
 * adjustment is handled and validated.
 *
 * @author Thomas Wen
 * @version 1
 */

public interface Adjustable {
    /**
     * Adjusts the weight of the equipment by the specified amount.
     *
     * <p>
     * Implementations should update the current weight only if the
     * resulting value remains within valid bounds (for example, not
     * exceeding the equipment's load capacity or dropping below zero).
     * </p>
     *
     * @param a the amount to adjust the current weight by;
     *          can be positive (to increase) or negative (to decrease)
     * @return {@code true} if the adjustment was successful and the
     *         equipment's weight was updated; {@code false} otherwise
     */
    boolean adjustWeight(int a);
}
