/**
 * Describes reason why market is unable to fulfill a transaction.
 * 
 * @author Thomas Wen
 * @version 1
 */
public class CannotFulfillTransactionException extends Exception {
    public CannotFulfillTransactionException(String str) {
        super(str);
    }
}
