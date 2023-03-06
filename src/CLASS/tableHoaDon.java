package CLASS;

public class tableHoaDon {

    private String id, name, donViTinh;
    private int soLuong, tang;
    private long donGia, thanhTien;


    public tableHoaDon(String id, String name, String donViTinh, int soLuong, int tang, long donGia, long thanhTien) {
        this.id = id;
        this.name = name;
        this.donViTinh = donViTinh;
        this.soLuong = soLuong;
        this.tang = tang;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }


    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public String getId() {
        return id;
    }

    public tableHoaDon() {
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

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public long getDonGia() {
        return donGia;
    }

    public void setDonGia(long donGia) {
        this.donGia = donGia;
    }

    public long getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(long thanhTien) {
        this.thanhTien = thanhTien;
    }

}
