package exception;

/**
 * Exception bắn ra khi tên nhân viên rỗng hoặc chứa ký tự không hợp lệ.
 */
public class FullNameException extends Exception {
    public FullNameException(String message) {
        super(message);
    }
}
