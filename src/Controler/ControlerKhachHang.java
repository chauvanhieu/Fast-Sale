package Controler;

import CLASS.khachHang;
import MODEL.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ControlerKhachHang {

    //Lấy mảng dữ liệu
    public static ArrayList<khachHang> getData() {
        ArrayList<khachHang> list = new ArrayList<khachHang>();
        try {

            Connection conn = model.getConnection();
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'table name'
            ResultSet rs = stmt.executeQuery("SELECT * FROM khachhang");
            // show data
            while (rs.next()) {
                list.add(new khachHang(rs.getString("id"), rs.getString("name"), rs.getString("diachi"), rs.getString("sodienthoai"), rs.getString("email"), rs.getLong("tienno"), rs.getInt("status") == 0 ? false : true));
            }

            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static class tenKhachHang {

        private String id, name;

        public tenKhachHang(String id, String name) {
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

    public static ArrayList<tenKhachHang> getTenKhachHang() {
        ArrayList<tenKhachHang> list = new ArrayList<tenKhachHang>();
        try {

            Connection conn = model.getConnection();
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'table name'
            ResultSet rs = stmt.executeQuery("SELECT id,name FROM khachhang");
            // show data
            while (rs.next()) {
                list.add(new tenKhachHang(rs.getString("id"), rs.getString("name")));
            }

            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static khachHang getKhachHang(String id) {
        khachHang kh = null;
        try {

            Connection conn = model.getConnection();
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'table name'
            ResultSet rs = stmt.executeQuery("SELECT * FROM khachhang where id = '" + id + "'");
            // show data
            while (rs.next()) {
                kh = new khachHang(rs.getString("id"), rs.getString("name"), rs.getString("diachi"), rs.getString("soDienThoai"), rs.getString("email"), rs.getLong("tienno"), rs.getInt("status") == 0 ? false : true);
            }

            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return kh;
    }

    //Thêm
    public static void add(khachHang kh) {
        String sql = "insert into khachhang values(?,?,?,?,?,?)";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, kh.getId());
            stm.setString(2, kh.getName());
            stm.setString(3, kh.getDiaChi());
            stm.setString(4, kh.getSoDienThoai());
            stm.setString(5, kh.getEmail());
            stm.setLong(6, kh.getTienNo());

            stm.execute();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Xóa
    public static void remove(String id) {
        String sql = "update khachhang set status = 0 where id = '" + id + "'";
//        String sqlXoaHoaDon = "update hoadon set status = 0 where khachhang ='" + id + "'";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
//            PreparedStatement stm2 = con.prepareStatement(sqlXoaHoaDon);
//            stm2.execute();
            stm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Cập nhật
    public static void update(khachHang kh) {
        String sql = "update khachhang set name = ?,diachi=?,sodienthoai=?,email=?,tienno=? where id = ?";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(6, kh.getId());
            stm.setString(1, kh.getName());
            stm.setString(2, kh.getDiaChi());
            stm.setString(3, kh.getSoDienThoai());
            stm.setString(4, kh.getEmail());
            stm.setLong(5, kh.getTienNo());
            stm.execute();
            stm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
