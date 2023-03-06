
package CLASS;

public class sanPham {

    private String id, name, donViTinh, maNhaCungCap;
    private long giaNhap, GiaBan;
    private int tonKho;

    public sanPham(String id, String name, String donViTinh, String maNhaCungCap, long giaNhap, long GiaBan, int tonKho) {
        this.id = id;
        this.name = name;
        this.donViTinh = donViTinh;
        this.maNhaCungCap = maNhaCungCap;
        this.giaNhap = giaNhap;
        this.GiaBan = GiaBan;
        this.tonKho = tonKho;
    }

    public sanPham() {
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

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public long getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(long giaNhap) {
        this.giaNhap = giaNhap;
    }

    public long getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(long GiaBan) {
        this.GiaBan = GiaBan;
    }

    public int getTonKho() {
        return tonKho;
    }

    public void setTonKho(int tonKho) {
        this.tonKho = tonKho;
    }

}
