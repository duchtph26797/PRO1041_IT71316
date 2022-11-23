/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.KichCoDomainModel;
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
public class KichCoRepository {

    public List<KichCoDomainModel> getAll() {
        List<KichCoDomainModel> listKC = new ArrayList<>();
        String query = "SELECT [MaKC]\n"
                + "      ,[TenKC]\n"
                + "  FROM [dbo].[KICHCO]";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listKC.add(new KichCoDomainModel(rs.getString(1), rs.getString(2)));
            }
            return listKC;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean Add(KichCoDomainModel kc) {
        int check = 0;
        String query = "INSERT INTO [dbo].[KICHCO]\n"
                + "           ([MaKC]\n"
                + "           ,[TenKC])\n"
                + "     VALUES\n"
                + "           (?, ?)";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kc.getMaKC());
            ps.setObject(2, kc.getTenKC());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(KichCoDomainModel kc, String ma) {
        int check = 0;
        String query = "UPDATE [dbo].[KICHCO]\n"
                + "   SET [TenKC] = ?\n"
                + " WHERE MaKC = ?";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kc.getTenKC());
            ps.setObject(2, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        int check = 0;
        String query = "DELETE FROM [dbo].[KICHCO]\n"
                + "      WHERE MaKC like ?";
        try(Connection con = DBConnection.openDbConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check >0;
    }

}
