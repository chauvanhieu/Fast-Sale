/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HELPER;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class ChuyenDoi {
    //Chuyển đổi kiểu Date <-> String
    //Tạo định dạng ngày tháng
    
    //Hàm chuyển Date -> String
    public static String LayNgayString(Date date,String Format){
        DateFormat dateFormat = new SimpleDateFormat(Format);
        return dateFormat.format(date);
    }
    
    //Hàm chuyển String -> Date
    public static Date LayNgayDate(String ngay,String Format){
        DateFormat dateFormat = new SimpleDateFormat(Format);
        try {
            return dateFormat.parse(ngay);
        } catch (ParseException ex) {
            System.out.println("Lỗi chuyển ngày");
            return null;
        }
    }
    
    //Chuyển đổi số Double <-> String 10.000.000
    //Hàm chuyển Double -> String
    public static String LongToString(double so){
        return NumberFormat.getNumberInstance().format(so);
    }
    
    //Hàm chuyển String -> Double
    public static double StringToLong(String so){
        try {
            return NumberFormat.getNumberInstance().parse(so).doubleValue();
        } catch (ParseException ex) {
            System.out.println("Lỗi chuyển số");
            return 0;
        }
    }
    
    public static String SoString(long so){
        return NumberFormat.getNumberInstance().format(so);
    }
    
    //Hàm chuyển String -> Double
    public static long SoLong(String so){
        try {
            return NumberFormat.getNumberInstance().parse(so).longValue();
        } catch (ParseException ex) {
            System.out.println("Lỗi chuyển số");
            return 0;
        }
    }
}
