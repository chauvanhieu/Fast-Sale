package Controler;

import CLASS.sanPham;
import MODEL.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ControlerSanPham {

    public static void nhapHang(String idsanpham, int soluongnhap, String idnhanvien) {
        String sql = "insert into nhaphang values(?,?,?,?)";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String ngayGio = dtf.format(now);
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, idsanpham);
            stm.setInt(2, soluongnhap);
            stm.setString(3, ngayGio);
            stm.setString(4, idnhanvien);
            stm.execute();
            con.close();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static sanPham getSanPham(String id) {
        String sql = "select sanpham.id as 'id',sanpham.name as 'name',nhacungcap.name as 'nhacungcap',donViTinh,tonkho,gianhap,giaban from sanpham \n"
                + "join nhacungcap on nhacungcap.id = sanpham.nhacungcap where sanpham.id = '" + id + "'";
        sanPham sp = null;
        try {
            Connection con = model.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                sp = new sanPham(rs.getString("id"), rs.getString("name"), rs.getString("donViTinh"), rs.getString("nhacungcap"), rs.getLong("gianhap"), rs.getLong("giaban"), rs.getInt("tonkho"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }

    public static void themSanPham(sanPham sp) {
        String sql = "insert into sanpham values(?,?,?,?,?,?,?,1)";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, sp.getId());
            stm.setString(2, sp.getName());
            stm.setString(3, sp.getDonViTinh());
            stm.setString(4, sp.getMaNhaCungCap());
            stm.setLong(5, sp.getGiaNhap());
            stm.setLong(6, sp.getGiaBan());
            stm.setInt(7, sp.getTonKho());
            stm.execute();
            con.close();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void capNhatSanPham(sanPham sp) {
        String sql = "update sanpham set name=?,donvitinh=?,nhacungcap=?,gianhap=?,giaban=?,tonkho=? where id = ?";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, sp.getName());
            stm.setString(2, sp.getDonViTinh());
            stm.setString(3, sp.getMaNhaCungCap());
            stm.setLong(4, sp.getGiaNhap());
            stm.setLong(5, sp.getGiaBan());
            stm.setLong(6, sp.getTonKho());
            stm.setString(7, sp.getId());
            stm.execute();
            con.close();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void xoaSanPham(String id) {
//        String xoachitiet = "delete from hoadonchitiet where sanpham = '" + id + "'";
//        String sql = "DELETE FROM sanpham WHERE `sanpham`.`id` = '" + id + "';";
        String sql = "update sanpham set status=0 where id = '" + id + "'";
//        try {
//            Connection con2 = model.getConnection();
////            PreparedStatement stm2 = con2.prepareStatement(xoachitiet);
//
//            stm2.execute();
//            con2.close();
//            stm2.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);

            stm.execute();
            con.close();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Lấy mảng dữ liệu
    public static ArrayList<sanPham> getData() {
        ArrayList<sanPham> list = new ArrayList<sanPham>();
        try {

            Connection conn = model.getConnection();
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'table name'
            ResultSet rs = stmt.executeQuery("select sanpham.id as 'id',sanpham.name as 'name',nhacungcap.name as 'nhacungcap',donViTinh,tonkho,gianhap,giaban,sanpham.status as 'trangthai' from sanpham \n"
                    + "join nhacungcap on nhacungcap.id = sanpham.nhacungcap");
            // show data
            while (rs.next()) {
                if (rs.getInt("trangthai") == 1) {
                    list.add(new sanPham(rs.getString("id"), rs.getString("name"), rs.getString("donViTinh"), rs.getString("nhacungcap"), rs.getLong("gianhap"), rs.getLong("giaban"), rs.getInt("tonkho")));
                }
            }

            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static class tenSanPham {

        private String id, name;

        public tenSanPham(String id, String name) {
            this.id = id;
            this.name = name;
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
    }

    public static ArrayList<tenSanPham> getTenSanPham() {
        ArrayList<tenSanPham> list = new ArrayList<tenSanPham>();
        try {

            Connection conn = model.getConnection();
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'table name'
            ResultSet rs = stmt.executeQuery("SELECT id,name FROM sanpham");
            // show data
            while (rs.next()) {
                list.add(new tenSanPham(rs.getString("id"), rs.getString("name")));
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static ArrayList<tenSanPham> getTenSanPham(String idnhacungcap) {
        String sql = "select sanpham.id as 'id',sanpham.name as 'name' from sanpham \n"
                + "join nhacungcap on nhacungcap.id=sanpham.nhacungcap\n"
                + "where nhacungcap.id = '" + idnhacungcap + "'";
        ArrayList<tenSanPham> list = new ArrayList<tenSanPham>();
        try {

            Connection conn = model.getConnection();
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'table name'
            ResultSet rs = stmt.executeQuery(sql);
            // show data
            while (rs.next()) {
                list.add(new tenSanPham(rs.getString("id"), rs.getString("name")));
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    //Thêm
    public static void add(sanPham sp) throws SQLException {
        String sql = "insert into sanpham values(?,?,?,?,?,?,?)";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, sp.getId());
            stm.setString(2, sp.getName());
            stm.setString(3, sp.getDonViTinh());
            stm.setString(4, sp.getMaNhaCungCap());
            stm.setLong(5, sp.getGiaNhap());
            stm.setLong(6, sp.getGiaBan());
            stm.setInt(7, sp.getTonKho());
            stm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Xóa
    public static void remove(String id) {
        String sql = "delete from sanpham where id = ?";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Cập nhật
    public static void update(sanPham sp) {
        String sql = "update sanpham set name = ?,donvitinh=?,nhacungcap=?,gianhap=?,giaban=?,tonkho=? where id = ?";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(7, sp.getId());
            stm.setString(1, sp.getName());
            stm.setString(2, sp.getDonViTinh());
            stm.setString(3, sp.getMaNhaCungCap());
            stm.setLong(4, sp.getGiaNhap());
            stm.setLong(5, sp.getGiaBan());
            stm.setInt(6, sp.getTonKho());
            stm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
