package Controler;

import CLASS.hoaDon;
import CLASS.tableHoaDon;
import HELPER.ChuyenDoi;
import MODEL.model;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControlerHoaDon {

    public static void reup(hoaDon hoadongoc, ArrayList<tableHoaDon> dataSanPhamGoc) {
        /*
                cộng lại nợ cũ
                cộng lại doanh thu cũ cho nhân viên
                trừ lại tồn kho như cũ
                insert lại chi tiết hóa đơn 
         */
        String congLaiNoCu = "update khachhang set tienno=tienno+" + hoadongoc.getTongTien() + " where id = '" + hoadongoc.getMaKhachHang() + "'";
        String congDoanhThu = "update nhanvien set doanhthu=doanhthu+ " + hoadongoc.getTongTien() + " where id = '" + hoadongoc.getNhanVienBan() + "' ";
        String truTonKho = "update sanpham set tonkho=tonkho-? where id = ?";
        String insertChiTiet = "insert into hoadonchitiet values('" + hoadongoc.getMaChiTietHoaDon() + "',?,?,?)";

        try {
            Connection con = model.getConnection();
            PreparedStatement stm1 = con.prepareStatement(congLaiNoCu);
            PreparedStatement stm2 = con.prepareStatement(congDoanhThu);
            PreparedStatement stm3 = con.prepareStatement(truTonKho);
            PreparedStatement stm4 = con.prepareStatement(insertChiTiet);
            stm1.execute();
            stm2.execute();

            for (tableHoaDon item : dataSanPhamGoc) {
                stm3.setString(2, item.getId());
                if (item.getTang() == 0) {
                    stm3.setInt(1, item.getSoLuong());
                } else {
                    stm3.setInt(1, item.getTang());
                }
                stm3.execute();

                stm4.setString(1, item.getId());
                if (item.getDonGia() == 0) {
                    stm4.setInt(2, 0);
                    stm4.setInt(3, item.getTang());
                } else {
                    stm4.setInt(2, item.getSoLuong());
                    stm4.setInt(3, 0);
                }
                stm4.execute();
            }
            stm1.close();
            stm2.close();
            stm3.close();
            stm4.close();
            con.close();
        } catch (Exception e) {
        }
    }

    public static void letUpdate(String idnhanvien, String idkhachhang, ArrayList<tableHoaDon> dataSanPham, long tongHoaDon, String idchitiet) {
        /*
        1. Cập nhật lại nợ cũ:    nợ hiện tại - tổng tiền hóa đơn
        2. Cập nhật lại doanh thu nhân viên:   doanh thu hiện tại trừ đi tổng tiền hóa đơn
        3. Cập nhật số lượng tồn kho từng sản phẩm đã bán: Có ArrayList từng SP => tồn kho hiện tại cộng cho số lượng tặng và số lượng bán
        4. Xóa chi tiết hóa đơn đó
         */
        String capNhatNoCu = "update khachhang set tienNo = tienNo - " + tongHoaDon + " where id = '" + idkhachhang + "'";
        String capNhatDoanhThu = "update nhanvien set doanhthu = doanhthu -  " + tongHoaDon + " where id = '" + idnhanvien + "'";
        String capNhatTonKho = "update sanpham set tonkho = tonkho + ? where id = ?";
        String xoaChiTiet = "delete from hoadonchitiet where id = '" + idchitiet + "'";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm1 = con.prepareStatement(capNhatNoCu);
            PreparedStatement stm2 = con.prepareStatement(capNhatDoanhThu);
            PreparedStatement stm3 = con.prepareStatement(capNhatTonKho);
            PreparedStatement stm4 = con.prepareStatement(xoaChiTiet);
            stm1.execute();
            stm2.execute();
            stm4.execute();
            for (tableHoaDon item : dataSanPham) {
                if (item.getDonGia() == 0) {
                    stm3.setLong(1, item.getTang());
                    stm3.setString(2, item.getId());
                } else {
                    stm3.setLong(1, item.getSoLuong());
                    stm3.setString(2, item.getId());
                }
                stm3.execute();
            }
            con.close();
            stm1.close();
            stm2.close();
            stm3.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Lấy tất cả mã hóa đơn
    public static ArrayList<String> getMaHoaDon() {
        ArrayList<String> list = new ArrayList<String>();
        String sql = "select id from hoaDon";
        try {
            Connection con = model.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getString("id"));
            }
            con.close();
            stm.close();
        } catch (Exception e) {
        }
        return list;
    }

    public static void getDoanhThu(JTable table, String dateFrom, String dateTo, JLabel lb) {
        String sql = "select sanpham.id as 'masanpham',sanpham.name 'tensanpham',sanpham.donViTinh as 'donvitinh',hoadonchitiet.soluong 'soluongban',hoadonchitiet.tang 'soluongtang',gianhap,giaban,hoadon.ngayGio,nhanvien.name as 'nhanvienban',khachHang.name as 'khachhang' from hoadonchitiet\n"
                + "join hoadon on hoadon.chitiethoadon=hoadonchitiet.id\n"
                + "join sanpham on hoadonchitiet.sanpham=sanpham.id\n"
                + "join nhanvien on hoadon.nhanvienban=nhanvien.id\n"
                + "join khachHang on hoadon.khachHang=khachHang.id\n"
                + "where  date(hoadon.ngayGio) BETWEEN '" + dateFrom + "' and '" + dateTo + "'";

        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.addColumn("Mã sản phẩm");
        modelTable.addColumn("Tên sản phẩm");
        modelTable.addColumn("Đơn vị tính");
        modelTable.addColumn("Số lượng bán");
        modelTable.addColumn("Số lượng tặng");
        modelTable.addColumn("Nhân viên bán");
        modelTable.addColumn("Khách hàng");
        modelTable.addColumn("Giá nhập");
        modelTable.addColumn("Giá bán");
        modelTable.addColumn("Ngày bán");
        modelTable.addColumn("Doanh thu");
        modelTable.addColumn("Lợi nhuận");

        long tongDoanhThu = 0;
        long tongLoiNhuan = 0;
        long doanhThu = 0;
        long loiNhuan = 0;
        long tienVon = 0;
        try {
            Connection con = model.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {

                if (rs.getLong("soluongban") == 0) {
                    doanhThu = 0;
                    tienVon = (rs.getLong("soluongban") + rs.getLong("soluongtang")) * rs.getLong("gianhap");
                    loiNhuan = doanhThu - tienVon;
                    tongDoanhThu += doanhThu;
                    tongLoiNhuan += loiNhuan;
                } else {
                    doanhThu = rs.getLong("soluongban") * rs.getLong("giaban") - (rs.getLong("soluongtang") * rs.getLong("gianhap"));
                    tienVon = (rs.getLong("soluongban") + rs.getLong("soluongtang")) * rs.getLong("gianhap");
                    loiNhuan = doanhThu - tienVon;
                    tongDoanhThu += doanhThu;
                    tongLoiNhuan += loiNhuan;
                }

                modelTable.addRow(new Object[]{
                    rs.getString("masanpham"),
                    rs.getString("tensanpham"),
                    rs.getString("donvitinh"),
                    rs.getString("soluongban"),
                    rs.getString("soluongtang"),
                    rs.getString("nhanvienban"),
                    rs.getString("khachhang"),
                    ChuyenDoi.SoString(rs.getLong("gianhap")),
                    ChuyenDoi.SoString(rs.getLong("giaban")),
                    rs.getString("ngayGio"),
                    ChuyenDoi.LongToString(doanhThu),
                    ChuyenDoi.LongToString(loiNhuan)
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        lb.setText("DOANH THU : " + ChuyenDoi.LongToString(tongDoanhThu) + "    LỢI NHUẬN : " + ChuyenDoi.LongToString(tongLoiNhuan));
        table.setModel(modelTable);
    }

    public static ArrayList<hoaDon> getHoaDon(String field, String value, String dateFrom, String dateTo) {
        ArrayList<hoaDon> list = new ArrayList<hoaDon>();
        try {
            Connection con = model.getConnection();
            String sql = "";
            if (field == "Mã hóa đơn") {
                sql = "select hoadon.id as 'id',khachHang.name as 'khachhang',tongtien,hinhthucthanhtoan,ngayGio,nhanvien.name as 'nhanvienban',chitiethoadon from hoadon\n"
                        + "                                      join nhanvien on hoadon.nhanvienban=nhanvien.id\n"
                        + "                                      join khachHang on hoadon.khachHang = khachHang.id\n"
                        + "                                      where   hoadon.id LIKE '%" + value + "%'\n"
                        + "                                         and date(hoadon.ngayGio) BETWEEN '" + dateFrom + "' and '" + dateTo + "'";

            } else if (field == "Nhân viên bán hàng") {
                sql = "select hoadon.id as 'id',khachHang.name as 'khachhang',tongtien,hinhthucthanhtoan,ngayGio,nhanvien.name as 'nhanvienban',chitiethoadon from hoadon\n"
                        + "    join nhanvien on hoadon.nhanvienban=nhanvien.id\n"
                        + "    join khachHang on hoadon.khachHang = khachHang.id\n"
                        + "    where   (nhanvien.name like '%" + value + "%' or nhanvien.id like '%" + value + "%' ) \n"
                        + "            and date(hoadon.ngayGio) BETWEEN '" + dateFrom + "' and '" + dateTo + "'";
            } else if (field == "Tên khách hàng") {
                sql = "select hoadon.id as 'id',khachHang.name as 'khachhang',tongtien,hinhthucthanhtoan,ngayGio,nhanvien.name as 'nhanvienban',chitiethoadon from hoadon\n"
                        + "    join nhanvien on hoadon.nhanvienban=nhanvien.id\n"
                        + "    join khachHang on hoadon.khachHang = khachHang.id\n"
                        + "    where   (khachhang.name like '%" + value + "%' or khachhang.id like '%" + value + "%' ) \n"
                        + "            and date(hoadon.ngayGio) BETWEEN '" + dateFrom + "' and '" + dateTo + "'";
            } else if (field == "Tất cả") {
                sql = "select hoadon.id as 'id',khachHang.name as 'khachhang',tongtien,hinhthucthanhtoan,ngayGio,nhanvien.name as 'nhanvienban',chitiethoadon from hoadon\n"
                        + "                                                                       join nhanvien on hoadon.nhanvienban=nhanvien.id\n"
                        + "                                                                         join khachHang on hoadon.khachHang = khachHang.id\n"
                        + "                                                                       where   (nhanvien.name like '%105%' or nhanvien.id like '%" + value + "%'\n"
                        + "                                                                        or khachhang.name like '%" + value + "%' or khachhang.id like '%" + value + "%' \n"
                        + "                                                                      or hoadon.khachHang like '%" + value + "%' or hoadon.nhanvienban like '%" + value + "%' \n"
                        + "                                                                   or hoadon.id like '%" + value + "%')\n"
                        + "                                                                       and date(hoadon.ngayGio) BETWEEN '" + dateFrom + "' and '" + dateTo + "'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                list.add(new hoaDon(rs.getString("id"), "", rs.getString("nhanvienban"), rs.getString("khachhang"), rs.getString("ngaygio"), rs.getString("hinhthucthanhtoan"), rs.getString("chitiethoadon"), rs.getLong("tongtien")));
            }
            con.close();
            stm.close();
        } catch (Exception e) {
        }
        return list;
    }

    public static ArrayList<hoaDon> getHoaDon() {
        ArrayList<hoaDon> list = new ArrayList<hoaDon>();
        String sql = "select hoadon.id as 'id',khachHang.name as 'khachhang',tongtien,hinhthucthanhtoan,ngayGio,nhanvien.name as 'nhanvienban',chitiethoadon from hoadon\n"
                + "join nhanvien on hoadon.nhanvienban=nhanvien.id\n"
                + "join khachHang on hoadon.khachHang = khachHang.id";
        try {
            Connection con = model.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                list.add(new hoaDon(rs.getString("id"), "", rs.getString("nhanvienban"), rs.getString("khachhang"), rs.getString("ngaygio"), rs.getString("hinhthucthanhtoan"), rs.getString("chitiethoadon"), rs.getLong("tongtien")));
            }
            con.close();
            stm.close();
        } catch (Exception e) {
        }
        return list;
    }

    public static class chiTietHoadon {

        private String id, idSanPham;
        private int soLuongBan, soLuongTang;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIdSanPham() {
            return idSanPham;
        }

        public void setIdSanPham(String idSanPham) {
            this.idSanPham = idSanPham;
        }

        public int getSoLuongBan() {
            return soLuongBan;
        }

        public void setSoLuongBan(int soLuongBan) {
            this.soLuongBan = soLuongBan;
        }

        public int getSoLuongTang() {
            return soLuongTang;
        }

        public void setSoLuongTang(int soLuongTang) {
            this.soLuongTang = soLuongTang;
        }

        public chiTietHoadon(String id, String idSanPham, int soLuongBan, int soLuongTang) {
            this.id = id;
            this.idSanPham = idSanPham;
            this.soLuongBan = soLuongBan;
            this.soLuongTang = soLuongTang;
        }

    }

    public static ArrayList<chiTietHoadon> getChiTietHoaDon(String id) {
        ArrayList<chiTietHoadon> list = new ArrayList<chiTietHoadon>();
        String sql = "SELECT * FROM chitiethoadon WHERE id = '" + id + "';";
        try {
            Connection con = model.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                list.add(new chiTietHoadon(rs.getString("id"), rs.getString("masanpham"), rs.getInt("soluong"), rs.getInt("tang")));
            }
            con.close();
            stm.close();
        } catch (Exception e) {
        }
        return list;
    }
}
