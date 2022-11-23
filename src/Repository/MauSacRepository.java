/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.MauSacDomainModel;
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
public class MauSacRepository {

    public List<MauSacDomainModel> getAll() {
        List<MauSacDomainModel> listMS = new ArrayList<>();
        String query = "SELECT [MaMS]\n"
                + "      ,[TenMS]\n"
                + "  FROM [dbo].[MAUSAC]";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listMS.add(new MauSacDomainModel(rs.getString(1), rs.getString(2)));

            }
            return listMS;

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean Add(MauSacDomainModel ms) {
        int check = 0;
        String query = "INSERT INTO [dbo].[MAUSAC]\n"
                + "           ([MaMS]\n"
                + "           ,[TenMS])\n"
                + "     VALUES\n"
                + "           (?, ?)";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ms.getMaMau());
            ps.setObject(2, ms.getTenMau());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean Update(MauSacDomainModel ms, String ma) {
        int check = 0;
        String query = "UPDATE [dbo].[MAUSAC]\n"
                + "   SET [TenMS] = ?\n"
                + " WHERE MaMS = ?";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ms.getTenMau());
            ps.setObject(2, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        int check = 0;
        String query = "DELETE FROM [dbo].[MAUSAC]\n"
                + "      WHERE MaMS like ?";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<MauSacDomainModel> timKiem(String ten) {
        String query = "SELECT [MaMS]\n"
                + "      ,[TenMS]\n"
                + "  FROM [dbo].[MAUSAC]\n"
                + "  where TenMS like N'%"+ten+"%'";
        List<MauSacDomainModel> list = new ArrayList<>();
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
//            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauSacDomainModel ms = new MauSacDomainModel(rs.getString(1), rs.getString(2));
                list.add(ms);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

}
