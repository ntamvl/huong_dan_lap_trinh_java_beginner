package exception;

/**
 * Exception bắn ra khi định dạng email không đúng chuẩn (vd: thieucu@, sai domain...).
 */
public class EmailException extends Exception {
    public EmailException(String message) {
        super(message);
    }
}
