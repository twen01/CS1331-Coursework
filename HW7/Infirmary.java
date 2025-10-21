/**
 * represents infirmaries to treat treatable troops.
 *
 * @author Thomas Wen
 * @version 1
 */
public class Infirmary {
    private String infirmaryName;
    private static int numberOfInfirmaries = 0;

    /**
     * 1-arg constructor.
     *
     * @param infirmaryName the infirmary name
     */
    public Infirmary(String infirmaryName) {
        this.infirmaryName = infirmaryName;
        numberOfInfirmaries++;
    }

    /**
     * get num of infirmaries.
     *
     * @return the number of infirmaries
     */
    public static int getNumberOfInfirmaries() {
        return numberOfInfirmaries;
    }

    /**
     * inspect troop.
     *
     * @param t the troop
     */
    public void inspectTroop(Troop t) {
        System.out.println(t.toString());
        if (t instanceof Barbarian) {
            ((Barbarian) t).scream();
        }
    }

    /**
     * do treatment.
     *
     * @param t the treatable
     */
    public void doTreatment(Treatable t) {
        if (t.needsTreatment()) {
            t.treat();
        } else {
            System.out.println("You are fine. You will not receive treatment at " + infirmaryName + " infirmary");
        }
    }

    /**
     * tostring.
     *
     * @return a String
     */
    @Override
    public String toString() {
        return infirmaryName + " infirmary";
    }

    /**
     * equals method.
     *
     * @param o the object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Infirmary)) {
            return false;
        }
        return infirmaryName.equals(((Infirmary) o).infirmaryName);
    }
}
