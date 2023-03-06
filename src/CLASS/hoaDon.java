package CLASS;

public class hoaDon {

    private String id, nhanVienTao, nhanVienBan, maKhachHang, ngayGio, hinhThucThanhToan, maChiTietHoaDon;
    private long tongTien;

    public hoaDon() {
    }

    public hoaDon(String id, String nhanVienTao, String nhanVienBan, String maKhachHang, String ngayGio, String hinhThucThanhToan, String maChiTietHoaDon, long tongTien) {
        this.id = id;
        this.nhanVienTao = nhanVienTao;
        this.nhanVienBan = nhanVienBan;
        this.maKhachHang = maKhachHang;
        this.ngayGio = ngayGio;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.maChiTietHoaDon = maChiTietHoaDon;
        this.tongTien = tongTien;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNhanVienTao() {
        return nhanVienTao;
    }

    public void setNhanVienTao(String nhanVienTao) {
        this.nhanVienTao = nhanVienTao;
    }

    public String getNhanVienBan() {
        return nhanVienBan;
    }

    public void setNhanVienBan(String nhanVienBan) {
        this.nhanVienBan = nhanVienBan;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getNgayGio() {
        return ngayGio;
    }

    public void setNgayGio(String ngayGio) {
        this.ngayGio = ngayGio;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public String getMaChiTietHoaDon() {
        return maChiTietHoaDon;
    }

    public void setMaChiTietHoaDon(String maChiTietHoaDon) {
        this.maChiTietHoaDon = maChiTietHoaDon;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

}
