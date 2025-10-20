/**
 * Interface that guarantees an object is "Treatable"
 * 
 * @author Thomas Wen
 * @version 1
 */
public interface Treatable {

    /**
     * Abstract method that will indicate whether a Treatable needs treatment
     * 
     * @return boolean
     */
    boolean needsTreatment();

    /**
     * Abstract method to treat a Treatable
     */
    void treat();
}
