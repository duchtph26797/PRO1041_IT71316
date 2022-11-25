/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Ulities.DBConnection;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author TRUNG DUC
 */
public class SanPhamRepository {
    
    final String get_all ="select masp from sanpham"; 
    public ArrayList<String> getListMaSp(){
        ArrayList<String> list=new ArrayList<>();
        try {
            ResultSet rs=DBConnection.getDataFromQuery(get_all);
            while (rs.next()) {                
                list.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    public static void main(String[] args) {
        SanPhamRepository sp=new SanPhamRepository();
        ArrayList<String> list=sp.getListMaSp();
        System.out.println(list);
    }
}
