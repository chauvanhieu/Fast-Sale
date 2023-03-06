/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import CLASS.User;
import MODEL.model;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ControlerUser {
    
    public static ArrayList<User> getData() {
        ArrayList<User> list = new ArrayList<>();
        String sql = "select * from account";
        try {
            Connection con = model.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
               
                list.add(new User(rs.getString("username"),
                                    rs.getString("password"),
                                    rs.getString("nhanvien"),
                                    rs.getInt("remember") == 1 ? true : false,
                                    rs.getInt("donhang") == 1 ? true : false,
                                    rs.getInt("themdonhang") == 1 ? true : false,
                                    rs.getInt("doanhthu") == 1 ? true : false,
                                    rs.getInt("khoHang") == 1 ? true : false,
                                    rs.getInt("danhMuc") == 1 ? true : false,
                                    rs.getInt("thuNo") == 1 ? true : false,
                                    rs.getInt("baoCao") == 1 ? true : false
                ));
            }
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static ArrayList<String> getUsername() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select username from account";
        try {
            Connection con = model.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getString("username"));
            }
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static User getUser(String username) {
        User user = null;
        String sql = "select * from account where username = '" + username + "'";
        try {
            Connection con = model.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                user = new User(rs.getString("username"),
                                    rs.getString("password"),
                                    rs.getString("nhanvien"),
                                    rs.getInt("remember") == 1 ? true : false,
                                    rs.getInt("donhang") == 1 ? true : false,
                                    rs.getInt("themdonhang") == 1 ? true : false,
                                    rs.getInt("doanhthu") == 1 ? true : false,
                                    rs.getInt("khoHang") == 1 ? true : false,
                                    rs.getInt("danhMuc") == 1 ? true : false,
                                    rs.getInt("thuNo") == 1 ? true : false,
                                    rs.getInt("baoCao") == 1 ? true : false
                );
            }
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public static void setRemember(String id, boolean remember) {
        String sql = "update account set remember=? where username = ?";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, remember == true ? 1 : 0);
            stm.setString(2, id);
            
            stm.execute();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void removeAccount(String user) {
        String sql = "delete from account where username = ?";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, user);
            stm.execute();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void addAccount(User acc) {
        String sql = "insert into account values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, acc.getUsername());
            stm.setString(2, acc.getPassword());
            stm.setString(3, acc.getNhanVien());
            stm.setInt(4, acc.isRemember() == true ? 1 : 0);
            stm.setInt(5, acc.isXemDonHang() == true ? 1 : 0);
            stm.setInt(6, acc.isThemDonHang() == true ? 1 : 0);
            stm.setInt(7, acc.isDoanhThu() == true ? 1 : 0);
            stm.setInt(8, acc.isKhoHang() == true ? 1 : 0);
            stm.setInt(9, acc.isDanhMuc() == true ? 1 : 0);
            stm.setInt(10, acc.isThuNo() == true ? 1 : 0);
            stm.setInt(11, acc.isBaoCao() == true ? 1 : 0);
            
            stm.execute();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void setAccount(User acc) {
        String sql = "update account set password=?,"
                            + " nhanvien=?,"
                            + "donhang=?,themdonhang=?,"
                            + "doanhthu=?,khohang=?,danhmuc=?,"
                            + "thuno=?,baocao=?"
                            + " where username = ?";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(10, acc.getUsername());
            stm.setString(1, acc.getPassword());
            stm.setString(2, acc.getNhanVien());
            stm.setInt(3, acc.isXemDonHang() == true ? 1 : 0);
            stm.setInt(4, acc.isThemDonHang() == true ? 1 : 0);
            stm.setInt(5, acc.isDoanhThu() == true ? 1 : 0);
            stm.setInt(6, acc.isKhoHang() == true ? 1 : 0);
            stm.setInt(7, acc.isDanhMuc() == true ? 1 : 0);
            stm.setInt(8, acc.isThuNo() == true ? 1 : 0);
            stm.setInt(9, acc.isBaoCao() == true ? 1 : 0);
            stm.execute();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static User login(String username, String password) {
        ArrayList<User> data = getData();
        
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getUsername().equals(username) && data.get(i).getPassword().equals(password)) {
                return data.get(i);
            }
        }
        return null;
    }
}
