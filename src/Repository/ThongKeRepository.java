/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.SanPham;
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

    public List<SanPham> getSanPham(String conditions) {
        List<SanPham> listSP = new ArrayList<>();
        String query = "select sp.MaSP, sp.TenSP, lh.TenLoai, ms.TenMS, kc.TenKC, cl.TenCL, ctsp.DonGia,\n"
                + "SUM(hdct.SoLuong) as 'So luong da ban', ctsp.SoLuong as 'So luong con lai',\n"
                + "sum(((hdct.SoLuong*ctsp.DonGia) - (hdct.SoLuong*ctsp.DonGia)*MucKM/100)) as 'Tong doanh thu'\n"
                + "from HDCT hdct\n"
                + "join HOADON hd on hdct.MaHD = hd.MaHD\n"
                + "join CHITIETSP ctsp on hdct.MaCTSP = ctsp.MaCTSP\n"
                + "join SANPHAM sp on ctsp.MaSP = sp.MaSP\n"
                + "join LOAIHANG lh on ctsp.MaLoai = lh.MaLoai\n"
                + "join MAUSAC ms on ctsp.MaMS = ms.MaMS\n"
                + "join KICHCO kc on ctsp.MaKC = kc.MaKC\n"
                + "join CHATLIEU cl on ctsp.MaCL = cl.MaCL\n"
                + "join KHUYENMAI km on hd.MaKM = km.MaKM\n"
                + "where hd.TrangThai = 1\n"
                + "group by sp.MaSP, sp.TenSP, lh.TenLoai, ms.TenMS, kc.TenKC, cl.TenCL, ctsp.DonGia, ctsp.SoLuong\n" + conditions;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listSP.add(new SanPham(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10)));
            }
            return listSP;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return listSP;
    }

    public static void main(String[] args) {
        System.out.println(new ThongKeRepository().getThongKe(""));
    }
}
