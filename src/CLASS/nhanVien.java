package CLASS;

public class nhanVien {

    private String id, name, soDienThoai, diaChi, ngaySinh;
    private boolean gioiTinh;
    private long tienLuong, doanhThu;
    private boolean status;
    public nhanVien(String id, String name, String soDienThoai, String diaChi, String ngaySinh, boolean gioiTinh, long tienLuong, long doanhThu,boolean status) {
        this.id = id;
        this.name = name;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.tienLuong = tienLuong;
        this.doanhThu = doanhThu;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(long doanhThu) {
        this.doanhThu = doanhThu;
    }

    public nhanVien() {
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

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public long getTienLuong() {
        return tienLuong;
    }

    public void setTienLuong(long tienLuong) {
        this.tienLuong = tienLuong;
    }

}
