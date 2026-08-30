package exception;

/**
 * Exception bắn ra khi số điện thoại không hợp lệ (không đủ 10 chữ số hoặc không bắt đầu bằng số 0).
 */
public class PhoneException extends Exception {
    public PhoneException(String message) {
        super(message);
    }
}
