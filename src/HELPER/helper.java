package HELPER;

import CLASS.hoaDon;
import CLASS.tableHoaDon;
import Controler.ControlerHoaDon;
import MODEL.model;
import java.awt.Color;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class helper {

    public static void validName(JTextField txt) {
        String text = txt.getText();
        if (isFullname(text)) {
            txt.setBorder(new LineBorder(Color.green));

        } else {
            txt.setBorder(new LineBorder(Color.red));

        }
    }

    public static void validEmail(JTextField txt) {
        String text = txt.getText();
        if (isEmail(text)) {
            txt.setBorder(new LineBorder(Color.green));

        } else {
            txt.setBorder(new LineBorder(Color.red));

        }
    }

    public static void validSoDienThoai(JTextField txt) {
        String text = txt.getText();
        if (isPhoneNumber(text)) {
            txt.setBorder(new LineBorder(Color.green));

        } else {
            txt.setBorder(new LineBorder(Color.red));

        }
    }

    public static void validUsername(JTextField txt) {
        String text = txt.getText();
        if (isUsername(text)) {
            txt.setBorder(new LineBorder(Color.green));

        } else {
            txt.setBorder(new LineBorder(Color.red));

        }
    }

    public static boolean isUsername(String username) {
        String regex = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
        return username.matches(regex);
    }

    public static boolean isPhoneNumber(String soDienThoai) {
        String regex = "/^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$/";
        return soDienThoai.matches(regex);
    }

    public static boolean isEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public static String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }

    public static boolean isFullname(String str) {
        String input = removeAccent(str);
        String regx = "^([a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđĐ]+)((\\s{1}[a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+){1,})$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public static void SortByName(ArrayList<tableHoaDon> list) {

        Collections.sort(list, new Comparator<tableHoaDon>() {
            @Override
            public int compare(tableHoaDon nv1, tableHoaDon nv2) {
                String[] s;
                String[] k;
                s = nv1.getName().split(" ");
                k = nv2.getName().split(" ");
                int p = (s[s.length - 1].length());
                int q = (k[k.length - 1].length());
                return (nv1.getName().substring(nv1.getName().length() - p, nv1.getName().length())).compareToIgnoreCase(nv2.getName().substring(nv2.getName().length() - q, nv2.getName().length()));
            }
        });
    }

    public static String newID(String type) {
        ArrayList<String> listId = ControlerHoaDon.getMaHoaDon();
        String id = "";
        boolean check = false;
        if (listId.size() != 0) {
            do {
                for (String item : listId) {
                    int number = (int) Math.floor(Math.random() * (99999 - 10000 + 1) + 10000);
                    id = type + Integer.toString(number);
                    if (!item.equals(id)) {
                        check = true;
                    }
                }
            } while (check == false);
        } else {
            int number = (int) Math.floor(Math.random() * (99999 - 10000 + 1) + 10000);
            id = type + Integer.toString(number);
        }
        return id;
    }

    public static void addItemHoaDon(ArrayList<tableHoaDon> listHoaDon, String id) {
        String insertItemSql = "insert into hoadonchitiet values(?,?,?,?);";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(insertItemSql);
            for (tableHoaDon item : listHoaDon) {
                stm.setString(1, id);
                stm.setString(2, item.getId());
                if (item.getDonGia() == 0) {
                    stm.setInt(3, 0);
                    stm.setInt(4, item.getTang());
                } else {
                    stm.setInt(3, item.getSoLuong());
                    stm.setInt(4, 0);
                }
                stm.execute();
            }

            stm.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateHoaDon(ArrayList<tableHoaDon> listHoaDon, hoaDon hoadon, long tongtien, String idNVBan) {
        String insertItemSql = "insert into hoadonchitiet values(?,?,?,?);";
        String updateHoaDon = "update hoadon set nhanvienban = ?, hinhthucthanhtoan=?,tongtien=? where id = ?";
        try {
            Connection con = model.getConnection();

            PreparedStatement stm2 = con.prepareStatement(updateHoaDon);
            stm2.setString(1, idNVBan);
            stm2.setString(2, hoadon.getHinhThucThanhToan());
            stm2.setLong(3, tongtien);
            stm2.setString(4, hoadon.getId());
            stm2.execute();

            PreparedStatement stm = con.prepareStatement(insertItemSql);
            for (tableHoaDon item : listHoaDon) {
                stm.setString(1, hoadon.getMaChiTietHoaDon());
                stm.setString(2, item.getId());
                if (item.getDonGia() == 0) {
                    stm.setInt(3, 0);
                    stm.setInt(4, item.getTang());
                } else {
                    stm.setInt(3, item.getSoLuong());
                    stm.setInt(4, 0);
                }
                stm.execute();
            }

            stm.close();
            stm2.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void giamSoLuongTonKho(ArrayList<tableHoaDon> listHoaDon) {
        String insertItemSql = "update sanpham set tonkho = tonkho - ? where id = ?";
        for (tableHoaDon item : listHoaDon) {
            try {
                int sum = item.getSoLuong() + item.getTang();
                Connection con = model.getConnection();
                PreparedStatement stm = con.prepareStatement(insertItemSql);
                stm.setInt(1, sum);
                stm.setString(2, item.getId());

                stm.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void addHoaDon(String idHoaDon, String idNvTao, String idNvBan, String idKH, String ngayGio, String hinhThuc, String idChiTietHoaDon, long tongTien) {
        // (id, nhanvientao,nhanvienban,idkhachhang,ngaygio,hinhthucchuyenkhoan,chitiethoadon,tongtien)
        String sql = "insert into hoadon values(?,?,?,?,?,?,?,?)";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, idHoaDon);
            stm.setString(2, idNvTao);
            stm.setString(3, idNvBan);
            stm.setString(4, idKH);
            stm.setString(5, ngayGio);
            stm.setString(6, hinhThuc);
            stm.setString(7, idChiTietHoaDon);
            stm.setLong(8, tongTien);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void congDoanhThu(long tongHoaDon, String id) {
        //update nhanvien set doanhthu = doanhthu + tổng hóa đơn where id = idnhanvien
        String sql = "update nhanvien set doanhthu = doanhthu + ? where id = ?";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setLong(1, tongHoaDon);
            stm.setString(2, id);
            stm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void congTienNo(long tienNo, String id) {
        //update khachhang set tienNo = nợ mới where id = id khách hàng
        String sql = "update khachhang set tienNo = ? where id = ?";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setLong(1, tienNo);
            stm.setString(2, id);
            stm.execute();
            con.close();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static hoaDon getHoaDon(String id) {
        String sql = "select * from hoadon where id = '" + id + "'";
        hoaDon hoadon = null;
        try {
            Connection con = model.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                hoadon = new hoaDon(rs.getString("id"), rs.getString("nhanvientao"), rs.getString("nhanvienban"), rs.getString("khachhang"), rs.getString("ngaygio"), rs.getString("hinhthucthanhtoan"), rs.getString("chitiethoadon"), rs.getLong("tongtien"));
            }
            con.close();
            stm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoadon;
    }

    public static ArrayList<tableHoaDon> getDataHoaDon(String idHoaDon) {
        ArrayList<tableHoaDon> list = new ArrayList<tableHoaDon>();
        String sql = "select sanpham.id as 'id',sanpham.name as 'name',sanpham.donViTinh as 'donvitinh',sanpham.giaban as 'dongia',soluong,tang,hoadon.tongtien as 'tongtien' from hoadon \n"
                + "join hoadonchitiet on hoadonchitiet.id=hoadon.chitiethoadon\n"
                + "JOIN sanpham on hoadonchitiet.sanpham=sanpham.id\n"
                + "where hoadon.id='" + idHoaDon + "'";

        try {
            Connection con = model.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                list.add(new tableHoaDon(rs.getString("id"), rs.getString("name"), rs.getString("donvitinh"), rs.getInt("soluong"), rs.getInt("tang"), rs.getLong("dongia"), rs.getLong("tongtien")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void xoaDonHang(String idHoaDon, String idChiTiet) {
        String sql = "delete from hoadonchitiet where id = '" + idChiTiet + "'";
        String sql2 = "delete from hoadon where id = '" + idHoaDon + "'";
        try {
            Connection con = model.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            con.close();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Connection con2 = model.getConnection();
            PreparedStatement stm2 = con2.prepareStatement(sql2);
            stm2.execute();
            con2.close();
            stm2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
