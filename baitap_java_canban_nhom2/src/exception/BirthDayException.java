package exception;

/**
 * Exception bắn ra khi ngày sinh không đúng định dạng (dd/MM/yyyy)
 * hoặc không hợp lệ theo lịch thực tế.
 */
public class BirthDayException extends Exception {
    public BirthDayException(String message) {
        super(message);
    }
}
