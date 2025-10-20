/**
 * Represents a training ground where heroes can train.
 *
 * @author Thomas Wen
 * @version 1.0
 */
public class TrainingGround {
    private String name;
    private double trainingMultiplier;
    private boolean isOutdoors;

    /**
     * Constructs a training ground with given properties.
     *
     * @param name               the name of the training ground
     * @param trainingMultiplier the training multiplier
     * @param isOutdoors         whether the training ground is outdoors
     */
    public TrainingGround(String name, double trainingMultiplier, boolean isOutdoors) {
        this.name = name;
        this.trainingMultiplier = trainingMultiplier < 0 ? 0 : trainingMultiplier;
        this.isOutdoors = isOutdoors;
    }

    /**
     * Constructs an indoor training ground with multiplier 1.
     *
     * @param name the name of the training ground
     */
    public TrainingGround(String name) {
        this(name, 1, false);
    }

    /**
     * Gets the name of the training ground.
     *
     * @return the training ground's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the training multiplier.
     *
     * @return the training multiplier
     */
    public double getTrainingMultiplier() {
        return trainingMultiplier;
    }

    /**
     * Checks if the training ground is outdoors.
     *
     * @return true if outdoors, false otherwise
     */
    public boolean isOutdoors() {
        return isOutdoors;
    }

    /**
     * Sets the training multiplier.
     *
     * @param trainingMultiplier the new training multiplier
     */
    public void setTrainingMultiplier(double trainingMultiplier) {
        this.trainingMultiplier = trainingMultiplier < 0 ? 0 : trainingMultiplier;
    }

    /**
     * Returns a string representation of the training ground.
     *
     * @return string describing the training ground
     */
    public String toString() {
        if (isOutdoors) {
            return "Outdoors Training Ground: " + name
                    + ". It has training multiplier "
                    + String.format("%.2f", trainingMultiplier) + ".";
        }
        return "Indoors Training Ground: " + name
                + ". It has training multiplier "
                + String.format("%.2f", trainingMultiplier) + ".";
    }

    /**
     * Checks if this training ground is equal to another object.
     *
     * @param o the object to compare
     * @return true if equal, false otherwise
     */
    public boolean equals(Object o) {
        if (!(o instanceof TrainingGround)) {
            return false;
        }
        TrainingGround t = (TrainingGround) o;
        return name.equals(t.getName()) && trainingMultiplier == t.getTrainingMultiplier()
                && isOutdoors == t.isOutdoors();
    }
}
