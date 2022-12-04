/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Ulities.DBConnection;
import ViewModel.DoanhThuView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nhatc
 */
public class ThongKeRepository {

    public DoanhThuView getThongKe(String conditions) {
        DoanhThuView dt = new DoanhThuView();
        String query = "select sum(((SoLuong*DonGia) - (SoLuong*DonGia)*MucKM/100)) as 'Tong doanh thu',\n"
                + "sum(SoLuong) as 'Tong so sp da ban',\n"
                + "count(hd.MaHD) as 'So hoa don da thanh toan'\n"
                + "from HDCT hdct\n"
                + "join HOADON hd on hdct.MaHD = hd.MaHD\n"
                + "join KHUYENMAI km on hd.MaKM = km.MaKM\n"
                + "where hd.TrangThai = 1" + conditions;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dt.setTongDoanhThu(rs.getInt(1));
                dt.setTongSanPham(rs.getInt(2));
                dt.setSoHoaDon(rs.getInt(3));
            }
            return dt;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return dt;
    }

    public static void main(String[] args) {
        System.out.println(new ThongKeRepository().getThongKe(""));
    }
}
