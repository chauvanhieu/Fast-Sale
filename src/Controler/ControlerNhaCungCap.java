package Controler;

import CLASS.nhaCungCap;
import MODEL.model;
import VIEW.traHangNcc.objectSP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ControlerNhaCungCap {

    public static nhaCungCap getNhaCungCap(String id) {
        String sql = "select * from nhacungcap where id='" + id + "'";
        nhaCungCap ncc = null;
        try {
            Connection con = model.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ncc = new nhaCungCap(rs.getString("id"), rs.getString("name"), rs.getString("sodienthoai"), rs.getString("diachi"));
            }
        } catch (Exception e) {
        }
        return ncc;
    }

    public static void traHang(ArrayList<objectSP> list, String idncc, String idnv) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String ngayGio = dtf.format(now);
        String tra = "insert into trahangnhacungcap values(?,?,?,?,?)";
        String capnhatsoluong = "update sanpham set tonkho = tonkho - ? where id =?";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(tra);
            PreparedStatement stm2 = con.prepareStatement(capnhatsoluong);

            for (objectSP item : list) {
                stm.setString(1, item.getId());
                stm.setString(2, idncc);
                stm.setInt(3, item.getSoluong());
                stm.setString(4, idnv);
                stm.setString(5, ngayGio);

                stm2.setInt(1, item.getSoluong());
                stm2.setString(2, item.getId());

                stm.execute();
                stm2.execute();
            }
            con.close();
            stm.close();
            stm2.close();
        } catch (Exception e) {
        }
    }

    //Lấy mảng dữ liệu
    public static ArrayList<nhaCungCap> getData() {
        ArrayList<nhaCungCap> list = new ArrayList<nhaCungCap>();
        try {

            Connection conn = model.getConnection();
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'table name'
            ResultSet rs = stmt.executeQuery("SELECT * FROM nhacungcap");
            // show data
            while (rs.next()) {
                list.add(new nhaCungCap(rs.getString("id"), rs.getString("name"), rs.getString("sodienthoai"), rs.getString("diachi")));
            }

            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static class tenNhaCungCap {

        private String id, name;

        public tenNhaCungCap(String id, String name) {
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

    public static ArrayList<tenNhaCungCap> getTenNhaCungCap() {
        ArrayList<tenNhaCungCap> list = new ArrayList<tenNhaCungCap>();
        try {

            Connection conn = model.getConnection();
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'table name'
            ResultSet rs = stmt.executeQuery("SELECT id,name FROM nhacungcap");
            // show data
            while (rs.next()) {
                list.add(new tenNhaCungCap(rs.getString("id"), rs.getString("name")));
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    //Thêm
    public static void add(nhaCungCap ncc) {
        String sql = "insert into nhacungcap values(?,?,?,?)";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, ncc.getId());
            stm.setString(2, ncc.getName());
            stm.setString(3, ncc.getSoDienThoai());
            stm.setString(4, ncc.getDiaChi());
            stm.execute();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Xóa
    public static void remove(String id) {
        String sql = "delete from nhacungcap where id = ?";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, id);
            stm.execute();
            stm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Cập nhật
    public static void update(nhaCungCap ncc) {
        String sql = "update nhacungcap set name = ?,sodienthoai=?,diachi=? where id = ?";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(4, ncc.getId());
            stm.setString(1, ncc.getName());
            stm.setString(2, ncc.getDiaChi());
            stm.setString(3, ncc.getSoDienThoai());
            stm.execute();
            stm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
