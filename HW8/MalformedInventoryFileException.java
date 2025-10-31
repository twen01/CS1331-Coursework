/**
 * Describes why file containing information of market is not valid.
 * 
 * @author Thomas Wen
 * @version 1
 */
public class MalformedInventoryFileException extends Exception {
    MalformedInventoryFileException(String str) {
        super(str);
    }
}
