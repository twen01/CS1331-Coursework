/**
 * Describes reason why market is unable to fulfill a transaction.
 *
 * @author Thomas Wen
 * @version 1
 */
public class CannotFulfillTransactionException extends Exception {
    /**
     * 1-arg constructor for exception.
     *
     * @param str the message for the exception
     */
    public CannotFulfillTransactionException(String str) {
        super(str);
    }
}
