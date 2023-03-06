package CLASS;

public class nhaCungCap {

    private String id, name, soDienThoai, diaChi;

    public nhaCungCap(String id, String name, String soDienThoai, String diaChi) {
        this.id = id;
        this.name = name;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

    public nhaCungCap() {
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

}
