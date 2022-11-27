/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.HDCTDomainModel;
import Ulities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DELL 5570
 */
public class HDCTRepository {

    public List<HDCTDomainModel> getAll() {
        List<HDCTDomainModel> listHDCT = new ArrayList<>();
        String query = "SELECT [MaHD]\n"
                + "      ,[MaCTSP]\n"
                + "      ,[NgayTao]\n"
                + "      ,[SoLuong]\n"
                + "      ,[DonGia]\n"
                + "  FROM [dbo].[HDCT]";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listHDCT.add(new HDCTDomainModel(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getInt(4), rs.getString(5)));
            }
            return listHDCT;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return listHDCT;
    }

    public boolean Add(HDCTDomainModel hdct) {
        int check = 0;
        String query = "INSERT INTO [dbo].[HDCT]\n"
                + "           ([MaHD]\n"
                + "           ,[MaCTSP]\n"
                + "           ,[NgayTao]\n"
                + "           ,[SoLuong]\n"
                + "           ,[DonGia])\n"
                + "     VALUES\n"
                + "           (?, ?, ?,?,?)";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hdct.getMaHD());
            ps.setObject(2, hdct.getMaCTSP());
            ps.setObject(3, new java.sql.Date(hdct.getNgayTao().getTime()));
            ps.setObject(4, hdct.getSoLuong());
            ps.setObject(5, hdct.getDonGia());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(HDCTDomainModel hdct, String maHd, String maCtsp) {
        int check = 0;
        String query = "UPDATE [dbo].[HDCT]\n"
                + "   SET [SoLuong] = ?\n"
                + "      ,[DonGia] = ?\n"
                + " WHERE MaHD = ? and mactsp=?";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hdct.getSoLuong());
            ps.setObject(2, hdct.getDonGia());
            ps.setObject(3, maHd);
            ps.setObject(4, maCtsp);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String maHD, String maCTSP) {
        int check = 0;
        String query = "DELETE FROM [dbo].[HDCT]\n"
                + "      WHERE MaHD = ? and MaCTSP = ?";
        try(Connection con = DBConnection.openDbConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, maHD);
            ps.setObject(2, maCTSP);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check >0;
    }

}
