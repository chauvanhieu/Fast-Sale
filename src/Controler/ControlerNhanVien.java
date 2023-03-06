package Controler;

import CLASS.nhanVien;
import MODEL.model;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControlerNhanVien {

    public static nhanVien getNhanVien(String id) {
        nhanVien nv = null;
        String sql = "select * from nhanvien where id = '" + id + "'";
        try {
            Connection con = model.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                nv = new nhanVien(rs.getString("id"), rs.getString("name"), rs.getString("sodienthoai"), rs.getString("diachi"), rs.getString("ngaysinh"), rs.getInt("gioitinh") == 1 ? true : false, rs.getLong("tienLuong"), rs.getLong("doanhthu"),rs.getInt("status")==0?false:true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nv;
    }

    public static void capNhatNhanVien(nhanVien nv) {
        String sql = "update nhanvien set name=?,sodienthoai=?,diachi=?,gioitinh=?,ngaysinh=?,tienluong=? where id = ?";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, nv.getName());
            stm.setString(2, nv.getSoDienThoai());
            stm.setString(3, nv.getDiaChi());
            stm.setInt(4, nv.isGioiTinh() == true ? 1 : 0);
            stm.setString(5, nv.getNgaySinh());
            stm.setLong(6, nv.getTienLuong());
            stm.setString(7, nv.getId());
            stm.execute();
            stm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //getData ArrayList
    public static ArrayList<nhanVien> getData() {
        ArrayList<nhanVien> list = new ArrayList<nhanVien>();
        String sql = "select * from nhanvien";

        try {
            Connection con = model.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                list.add(new nhanVien(rs.getString("id"), rs.getString("name"), rs.getString("sodienthoai"), rs.getString("diachi"), rs.getString("ngaysinh"), rs.getInt("gioitinh") == 1 ? true : false, rs.getLong("tienLuong"), rs.getLong("doanhthu"),rs.getInt("status")==0?false:true));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static class tenNhanVien {

        private String id, name;

        public tenNhanVien(String id, String name) {
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

    public static ArrayList<tenNhanVien> getTenNhanVien() {
        ArrayList<tenNhanVien> list = new ArrayList<tenNhanVien>();
        try {

            Connection conn = model.getConnection();
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'table name'
            ResultSet rs = stmt.executeQuery("SELECT id,name FROM nhanvien");
            // show data
            while (rs.next()) {
                list.add(new tenNhanVien(rs.getString("id"), rs.getString("name")));
            }

            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    //thêm
    public static void add(nhanVien nv) {
        String sql = "insert into nhanvien values(?,?,?,?,?,?,?,?,1)";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, nv.getId());
            stm.setString(2, nv.getName());
            stm.setString(3, nv.getSoDienThoai());
            stm.setString(4, nv.getDiaChi());
            stm.setString(5, nv.getNgaySinh());
            stm.setInt(6, nv.isGioiTinh() == true ? 1 : 0);
            stm.setLong(7, nv.getTienLuong());
            stm.setLong(8, nv.getDoanhThu());
            stm.execute();
            stm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //xóa
    public static void remove(String id) {
//        String sql = "delete from nhanvien where id = ?";
          String sql = "update nhanvien set status = 0 where id = '"+id+"'";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            
            stm.execute();
            stm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //sữa
    public static void update(nhanVien nv) {
        String sql = "update nhanVien set name=?, sodienthoai=?,diachi=?,ngaysinh=?,gioiTinh=?,tienluong=?,doanhthu=? where id = ?";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(8, nv.getId());
            stm.setString(1, nv.getName());
            stm.setString(2, nv.getSoDienThoai());
            stm.setString(3, nv.getDiaChi());
            stm.setString(4, nv.getNgaySinh());
            stm.setInt(5, nv.isGioiTinh() == true ? 1 : 0);
            stm.setLong(6, nv.getTienLuong());
            stm.setLong(7, nv.getDoanhThu());
            stm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
