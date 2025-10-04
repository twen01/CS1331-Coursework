public class TrainingGround {
    private String name;
    private double trainingMultiplier;
    private boolean isOutdoors;

    public TrainingGround(String name, double trainingMultiplier, boolean isOutdoors) {
        this.name = name;
        this.trainingMultiplier = trainingMultiplier < 0 ? 0 : trainingMultiplier;
        this.isOutdoors = isOutdoors;
    }

    public TrainingGround(String name) {
        this.name = name;
        trainingMultiplier = 1;
        isOutdoors = false;
    }

    public String getName() {
        return name;
    }

    public double getTrainingMultiplier() {
        return trainingMultiplier;
    }

    public boolean isOutdoors() {
        return isOutdoors;
    }

    public void setTrainingMultiplier(double trainingMultiplier) {
        this.trainingMultiplier = trainingMultiplier < 0 ? 0 : trainingMultiplier;
    }

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

    public boolean equals(TrainingGround t) {
        return name.equals(t.getName()) && trainingMultiplier == t.getTrainingMultiplier()
                && isOutdoors == t.isOutdoors();
    }
}
