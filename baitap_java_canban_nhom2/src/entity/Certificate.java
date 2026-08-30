package entity;

/**
 * Lớp Certificate đại diện cho thông tin Bằng cấp của nhân viên.
 * Mỗi nhân viên có thể sở hữu nhiều Bằng cấp (Quan hệ Has-A với Employee).
 */
public class Certificate {
    private String certificatedID;
    private String certificateName;
    private String certificateRank;
    private String certificatedDate;

    // 1. Constructor không tham số (Default Constructor)
    public Certificate() {
    }

    // 2. Constructor đầy đủ tham số (Parameterized Constructor)
    public Certificate(String certificatedID, String certificateName, String certificateRank, String certificatedDate) {
        this.certificatedID = certificatedID;
        this.certificateName = certificateName;
        this.certificateRank = certificateRank;
        this.certificatedDate = certificatedDate;
    }

    // Getters and Setters (Tính đóng gói - Encapsulation)
    public String getCertificatedID() {
        return certificatedID;
    }

    public void setCertificatedID(String certificatedID) {
        this.certificatedID = certificatedID;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateRank() {
        return certificateRank;
    }

    public void setCertificateRank(String certificateRank) {
        this.certificateRank = certificateRank;
    }

    public String getCertificatedDate() {
        return certificatedDate;
    }

    public void setCertificatedDate(String certificatedDate) {
        this.certificatedDate = certificatedDate;
    }

    /**
     * Phương thức hiển thị chi tiết thông tin bằng cấp
     */
    public void showInfo() {
        System.out.printf("   + [Bằng cấp] Mã: %-8s | Tên: %-20s | Xếp loại: %-10s | Ngày cấp: %-10s\n",
                certificatedID, certificateName, certificateRank, certificatedDate);
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "certificatedID='" + certificatedID + '\'' +
                ", certificateName='" + certificateName + '\'' +
                ", certificateRank='" + certificateRank + '\'' +
                ", certificatedDate='" + certificatedDate + '\'' +
                '}';
    }
}
