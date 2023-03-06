package CLASS;

public class khachHang {

    private String id, name, diaChi, soDienThoai, email;
    private long tienNo;
    private boolean status;
    public khachHang() {

    }

    public khachHang(String id, String name, String diaChi, String soDienThoai, String email, long tienNo,boolean status) {
        this.id = id;
        this.name = name;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.tienNo = tienNo;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTienNo() {
        return tienNo;
    }

    public void setTienNo(long tienNo) {
        this.tienNo = tienNo;
    }

    
}
