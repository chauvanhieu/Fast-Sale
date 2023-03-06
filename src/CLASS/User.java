/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASS;

public class User {

    private String username, password, nhanvien;
    private boolean remember, xemDonHang, themDonHang, doanhThu, khoHang, danhMuc, thuNo, baoCao;

   

    public boolean isXemDonHang() {
        return xemDonHang;
    }

    public void setXemDonHang(boolean xemDonHang) {
        this.xemDonHang = xemDonHang;
    }

    public boolean isThemDonHang() {
        return themDonHang;
    }

    public void setThemDonHang(boolean themDonHang) {
        this.themDonHang = themDonHang;
    }

    public boolean isDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(boolean doanhThu) {
        this.doanhThu = doanhThu;
    }

    public boolean isKhoHang() {
        return khoHang;
    }

    public void setKhoHang(boolean khoHang) {
        this.khoHang = khoHang;
    }

    public boolean isDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(boolean danhMuc) {
        this.danhMuc = danhMuc;
    }

    public boolean isThuNo() {
        return thuNo;
    }

    public void setThuNo(boolean thuNo) {
        this.thuNo = thuNo;
    }

    public boolean isBaoCao() {
        return baoCao;
    }

    public void setBaoCao(boolean baoCao) {
        this.baoCao = baoCao;
    }

    public User(String username, String password, String nhanvien, boolean remember, boolean xemDonHang, boolean themDonHang, boolean doanhThu, boolean khoHang, boolean danhMuc, boolean thuNo, boolean baoCao) {
        this.username = username;
        this.password = password;
        this.nhanvien = nhanvien;
        this.remember = remember;
        this.xemDonHang = xemDonHang;
        this.themDonHang = themDonHang;
        this.doanhThu = doanhThu;
        this.khoHang = khoHang;
        this.danhMuc = danhMuc;
        this.thuNo = thuNo;
        this.baoCao = baoCao;
    }

    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNhanVien() {
        return nhanvien;
    }

    public void setNhanVien(String name) {
        this.nhanvien = name;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

   

}
