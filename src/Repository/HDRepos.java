/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.HoaDonModel;
import Ulities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class HDRepos {

    public List<HoaDonModel> getAll() {
        String query = "SELECT [MaHD]\n"
                + "      ,[NgayTao]\n"
                + "      ,[TrangThai]\n"
                + "      ,[MaNV]\n"
                + "      ,[MaKH]\n"
                + "      ,[MaKM]\n"
                + "  FROM [dbo].[HOADON]";
        try ( Connection cn = DBConnection.openDbConnection();  PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonModel> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new HoaDonModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(HoaDonModel Hd) {
        String query = "INSERT INTO HOADON values (?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, Hd.getNgayTao());
            ps.setObject(2, Hd.getTrangThai());
            ps.setObject(3, Hd.getMaNV());
            ps.setObject(4, Hd.getMaKH());
            ps.setObject(5, Hd.getMaKM());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    final String suaHD = "UPDATE [dbo].[HOADON]\n"
            + "   SET [NgayTao] = ?\n"
            + "      ,[TrangThai] = ?\n"
            + "      ,[MaNV] = ?\n"
            + "      ,[MaKH] = ?\n"
            + "      ,[MaKM] = ?\n"
            + " WHERE MaHD = ?";

    public Boolean suaHD(HoaDonModel Hd, String ma) {
        try {
            if (DBConnection.ExcuteQuery(
                    suaHD,
                    Hd.getMaHD(),
                    Hd.getNgayTao(),
                    Hd.getTrangThai(),
                    Hd.getMaNV(),
                    Hd.getMaKH(),
                    Hd.getMaKM(),
                    ma) == 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) {
        new HDRepos().getAll().forEach(s -> System.out.println(s.toString()));
    }
}
